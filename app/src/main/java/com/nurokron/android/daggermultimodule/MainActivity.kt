package com.nurokron.android.daggermultimodule

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.nurokron.android.daggermultimodule.navigation.NavigationHost

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        (applicationContext as DaggerMultiModuleApplication)
//            .applicationDaggerComponent
//            .inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost(
                lifecycleOwner = this
            )
        }
    }
}
