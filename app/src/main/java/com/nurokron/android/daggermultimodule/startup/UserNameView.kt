package com.nurokron.android.daggermultimodule.startup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nurokron.android.feature.standard.theme.DaggerMultimoduleTheme

@Composable
fun UserNameView(
    viewModel: UserNameViewModel,
) {
    val name by viewModel.userName.collectAsState()
    UserNameScreen(
        name
    )
}

@Composable
private fun UserNameScreen(
    name: String,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Welcome to the application..."
            )
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "You are $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerMultimoduleTheme {
        UserNameScreen("Android")
    }
}