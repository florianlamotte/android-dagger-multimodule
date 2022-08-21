package com.nurokron.android.daggermultimodule.navigation.dynamicmodule

import android.content.Intent
import androidx.fragment.app.Fragment

abstract class NavigationDynamicModuleUserAge {

    companion object {
        private const val NAVIGATION_MODULE_USER_AGE =
            "com.nurokron.android.useragedynamicmodule.NavigationModuleUserAge"

        private fun getInstanceOfNavigationModule(): NavigationDynamicModuleUserAge {
            val activityClass: Class<out NavigationDynamicModuleUserAge>
            try {
                activityClass = Class.forName(
                    NAVIGATION_MODULE_USER_AGE
                ) as Class<out NavigationDynamicModuleUserAge>
            } catch (e: ClassNotFoundException) {
                throw e
            }
            return activityClass.newInstance()
        }

        @JvmStatic
        fun newInstance(
        ): Fragment {
            return getInstanceOfNavigationModule().newFragmentInstanceNavigator()
        }
    }

    /**
     * Creates a parameterized PDP intent.
     */
    abstract fun newFragmentInstanceNavigator(
    ): Fragment
}