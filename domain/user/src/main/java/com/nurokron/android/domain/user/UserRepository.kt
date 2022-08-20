package com.nurokron.android.domain.user

import kotlinx.coroutines.flow.StateFlow

interface UserRepository {
    fun getUser(): StateFlow<User>
}