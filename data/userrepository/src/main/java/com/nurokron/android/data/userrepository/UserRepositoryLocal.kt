package com.nurokron.android.data.userrepository

import android.util.Log
import com.nurokron.android.domain.user.User
import com.nurokron.android.domain.user.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryLocal @Inject constructor(
): UserRepository {
    override fun getUser(): Flow<User> {
        return flow {
            listOf(
                "Pam",
                "Clarence",
                "Senechal",
                "Pompadour"
            ).forEach {
                emit(
                    User(it, 24)
                )
                Log.v("USER_REPOSITORY", "Emitted $it")
                delay(3000)
            }
        }
    }

}