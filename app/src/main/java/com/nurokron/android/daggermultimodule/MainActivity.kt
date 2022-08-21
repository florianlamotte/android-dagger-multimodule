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
import com.nurokron.android.daggermultimodule.navigation.NavigationHost
import com.nurokron.android.daggermultimodule.startup.UserNameView
import com.nurokron.android.data.userrepository.UserRepositoryLocal
import com.nurokron.android.domain.user.usecase.GetUser
import com.nurokron.android.feature.usersex.UserSexView
import com.nurokron.android.feature.usersex.UserSexViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        (applicationContext as DaggerMultiModuleApplication)
//            .applicationDaggerComponent
//            .inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}
