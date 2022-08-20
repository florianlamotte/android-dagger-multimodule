package com.nurokron.android.daggermultimodule.startup

import androidx.lifecycle.ViewModel

class UserViewModel(
) : ViewModel() {

    fun getUserData(): String {
        return "Pam"
    }
}