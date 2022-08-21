package com.nurokron.android.feature.usersex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurokron.android.domain.user.User
import com.nurokron.android.domain.user.usecase.GetUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserSexViewModel @Inject constructor(
    private val getUser: GetUser,
) : ViewModel() {
    private var _user = MutableStateFlow(User("poop", 22))
    val user = _user.asStateFlow()

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