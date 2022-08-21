package com.nurokron.android.daggermultimodule.startup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurokron.android.domain.user.usecase.GetUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserNameViewModel @Inject constructor(
    private val getUser: GetUser
) : ViewModel() {

    private val _userName = MutableStateFlow("No user")
    val userName: StateFlow<String> = _userName

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            getUser().collect {
                _userName.value = it.name
            }
        }
    }
}