package com.nurokron.android.useragedynamicmodule.dynamic

import com.nurokron.android.daggermultimodule.navigation.dynamicmodule.NavigationDynamicModuleUserAge
import com.nurokron.android.useragedynamicmodule.UserAgeNavigationFragment
import javax.inject.Inject

class NavigationModuleUserAge @Inject constructor(
) : NavigationDynamicModuleUserAge() {
    override fun newFragmentInstanceNavigator(
    ): UserAgeNavigationFragment {
        return UserAgeNavigationFragment.newInstance(
        )
    }
}