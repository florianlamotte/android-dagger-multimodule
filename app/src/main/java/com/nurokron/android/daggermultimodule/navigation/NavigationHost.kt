package com.nurokron.android.daggermultimodule.navigation

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.nurokron.android.daggermultimodule.di.DaggerApplicationComponent
import com.nurokron.android.daggermultimodule.di.daggerViewModel
import com.nurokron.android.daggermultimodule.startup.UserNameView
import com.nurokron.android.feature.usersex.UserSexView

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    lifecycleOwner: LifecycleOwner,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "userProfile"
    ) {
        val applicationComponent = DaggerApplicationComponent.builder().build()

        composable(
            "userProfile"
        ) {
            val userNameViewModel = daggerViewModel {
                applicationComponent.getUserNameViewModel()
            }
            UserNameView(
                userNameViewModel,
                buttonClickUserSex = {
                    navController.navigate("userSexScreen")
                },
                buttonClickUserAgeDyna = {
                    navigateToDynamicModuleAge(
                        lifecycleOwner,
                        navController
                    )
                }
            )
        }

        composable(
            "userSexScreen"
        ) {
            val userSexViewModel = daggerViewModel {
                applicationComponent.getUserSexViewModel()
            }
            UserSexView(
                userSexViewModel
            )
        }

        composable(
            "userAgeScreen"
        ) {
            Text(text = "Well done you navigated... not really! AHAHAHAHAH!")
        }
    }
}

private fun navigateToDynamicModuleAge(
    lifecycleOwner: LifecycleOwner,
    navController: NavHostController,
) {
    val installMonitor = DynamicInstallMonitor()
    navController.navigate(
        "userAgeScreen",
        navigatorExtras = DynamicExtras(
            installMonitor
        )
    )

    // check state
    if (installMonitor.isInstallRequired) {
        installMonitor.status.observe(
            lifecycleOwner,
            object : Observer<SplitInstallSessionState> {
                override fun onChanged(sessionState: SplitInstallSessionState) {
                    when (sessionState.status()) {
                        SplitInstallSessionStatus.INSTALLED -> {
                            navController.navigate(
                                "userAgeScreen"
                            )
                        }

                        SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {}
                        SplitInstallSessionStatus.FAILED -> {}
                        SplitInstallSessionStatus.CANCELED -> {}
                    }

                    if (sessionState.hasTerminalStatus()) {
                        installMonitor.status.removeObserver(this);
                    }
                }
            }
        )
    }
}