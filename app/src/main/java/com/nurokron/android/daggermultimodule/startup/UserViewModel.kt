package com.nurokron.android.daggermultimodule.startup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurokron.android.domain.user.usecase.GetUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val getUser: GetUser
) : ViewModel() {

    private val _userName = MutableStateFlow("No user")
    val userName: StateFlow<String> = _userName

    fun getUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            _userName.value = getUser().name
        }
    }
}