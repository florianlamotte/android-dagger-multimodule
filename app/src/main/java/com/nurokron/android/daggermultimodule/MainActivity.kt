package com.nurokron.android.daggermultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nurokron.android.daggermultimodule.di.DaggerApplicationComponent
import com.nurokron.android.daggermultimodule.di.daggerViewModel
import com.nurokron.android.daggermultimodule.startup.UserNameView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        (applicationContext as DaggerMultiModuleApplication)
//            .applicationDaggerComponent
//            .inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            Navigator()
        }
    }

    @Composable
    private fun Navigator() {
        val navController = rememberNavController()
        NavHost(
            navController,
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
                    userViewModel
                )
            }

            composable(
                "userAgeScreen"
            ) {
            }
        }
    }
}
