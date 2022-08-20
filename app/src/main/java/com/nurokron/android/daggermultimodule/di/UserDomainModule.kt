package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.data.userrepository.UserRepositoryLocal
import com.nurokron.android.domain.user.UserRepository
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        UserDomainModule.BindModule::class
    ]
)
class UserDomainModule {
    @Module
    internal interface BindModule {
        @Binds
        fun bindUserRepository(
            userRepository: UserRepositoryLocal
        ): UserRepository
    }
}