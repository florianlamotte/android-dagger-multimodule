package com.nurokron.android.domain.user.usecase

import com.nurokron.android.domain.user.User
import com.nurokron.android.domain.user.UserRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetUser @Inject constructor(
    private val userRepository: UserRepository,
) {
    operator fun invoke(): StateFlow<User> {
        return userRepository.getUser()
    }
}