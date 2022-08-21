package com.nurokron.android.data.userrepository

import android.util.Log
import com.nurokron.android.domain.user.Sex
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
                User(
                    "Pam",
                    24,
                    Sex.FEMALE,
                ),
                User(
                    "Clarence",
                    23,
                    Sex.MALE,
                ),
                User(
                    "Senechal",
                    34,
                    Sex.MALE,
                ),
                User(
                    "Pompadour",
                    31,
                    Sex.MALE
                ),
            ).forEach {
                emit(it)
                Log.v("USER_REPOSITORY", "Emitted $it")
                delay(3000)
            }
        }
    }

}