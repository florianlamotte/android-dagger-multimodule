package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.daggermultimodule.startup.UserViewModel
import dagger.Component

@Component(
    modules = [
        UserDomainModule::class,
    ]
)
interface ApplicationComponent {
    fun getUserViewModel(): UserViewModel
}