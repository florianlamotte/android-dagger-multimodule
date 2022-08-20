package com.nurokron.android.daggermultimodule.startup

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurokron.android.domain.user.usecase.GetUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val getUser: GetUser
) : ViewModel() {

    private val _userName = MutableStateFlow("No user")
    val userName: StateFlow<String> = _userName

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(5000)
            val user = getUser().stateIn(
                viewModelScope
            ).value
            _userName.value = user.name
        }
    }
}