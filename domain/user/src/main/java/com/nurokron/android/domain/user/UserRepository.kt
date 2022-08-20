package com.nurokron.android.domain.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<User>
}