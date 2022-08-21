package com.nurokron.android.feature.usersex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UserSexView(
    viewModel: UserSexViewModel,
) {
    val user by viewModel.user.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        UserData(
            user.name,
            user.sex.name
        )
    }
}

@Composable
fun UserData(
    name: String,
    sex: String
) {
    Text(text = "User: $name - Sex: $sex")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerMultimoduleTheme {
        Greeting("Android")
    }
}