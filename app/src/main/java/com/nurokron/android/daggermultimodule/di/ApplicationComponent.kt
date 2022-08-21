package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.daggermultimodule.di.domain.UserDomainModule
import com.nurokron.android.daggermultimodule.startup.UserNameViewModel
import com.nurokron.android.feature.usersex.UserSexViewModel
import dagger.Component

@Component(
    modules = [
        UserDomainModule::class,
    ]
)
interface ApplicationComponent {
    fun getUserNameViewModel(): UserNameViewModel

    fun getUserSexViewModel(): UserSexViewModel
}