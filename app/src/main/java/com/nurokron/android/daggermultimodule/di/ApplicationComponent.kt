package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.daggermultimodule.startup.UserNameViewModel
import dagger.Component

@Component(
    modules = [
        UserDomainModule::class,
    ]
)
interface ApplicationComponent {
    fun getUserViewModel(): UserNameViewModel
}