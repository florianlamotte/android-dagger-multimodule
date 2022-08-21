package com.nurokron.android.useragedynamicmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurokron.android.domain.user.Sex
import com.nurokron.android.domain.user.User
import com.nurokron.android.domain.user.usecase.GetUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserAgeViewModel @Inject constructor(
    private val getUser: GetUser,
): ViewModel() {
    private var _user: MutableStateFlow<User> = MutableStateFlow(
        User(
            "no name",
            99,
            Sex.MALE,
        )
    )
    val user: StateFlow<User> = _user

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            getUser().collect {
                _user.value = it
            }
        }
    }
}
