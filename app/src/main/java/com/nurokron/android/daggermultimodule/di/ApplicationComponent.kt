package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.daggermultimodule.MainActivity
import com.nurokron.android.daggermultimodule.startup.UserViewModel
import dagger.Component

@Component
interface ApplicationComponent {
    fun getUserViewModel(): UserViewModel
}