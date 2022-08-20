package com.nurokron.android.domain.user.usecase

import com.nurokron.android.domain.user.User
import javax.inject.Inject

class GetUser @Inject constructor(
) {
    suspend operator fun invoke(): User {
        return User(
            "Pam",
            28
        )
    }
}