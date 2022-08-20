package com.nurokron.android.domain.user.usecase

import com.nurokron.android.domain.user.User

class GetUser constructor() {
    suspend fun getUser(): User {
        return User(
            "Pam",
            28
        )
    }
}