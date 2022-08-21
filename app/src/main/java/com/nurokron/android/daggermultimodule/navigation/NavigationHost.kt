package com.nurokron.android.daggermultimodule.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nurokron.android.daggermultimodule.di.DaggerApplicationComponent
import com.nurokron.android.daggermultimodule.di.daggerViewModel
import com.nurokron.android.daggermultimodule.startup.UserNameView
import com.nurokron.android.data.userrepository.UserRepositoryLocal
import com.nurokron.android.domain.user.usecase.GetUser
import com.nurokron.android.feature.usersex.UserSexView
import com.nurokron.android.feature.usersex.UserSexViewModel

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
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
            val userViewModel = daggerViewModel {
                applicationComponent.getUserViewModel()
            }
            UserNameView(
                userViewModel,
                buttonClickUserSex = {
                    navController.navigate("userSexScreen")
                }
            )
        }

        composable(
            "userSexScreen"
        ) {
            UserSexView(
                UserSexViewModel(
                    GetUser(
                        UserRepositoryLocal()
                    )
                )
            )
        }
    }
}