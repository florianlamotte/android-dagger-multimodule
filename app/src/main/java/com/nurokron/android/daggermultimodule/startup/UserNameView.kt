package com.nurokron.android.daggermultimodule.startup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UserNameView(
    viewModel: UserNameViewModel,
    buttonClickUserSex: () -> Unit,
    buttonClickUserAgeDyna: () -> Unit,
) {
    val name by viewModel.userName.collectAsState()
    UserNameScreen(
        name,
        buttonClickUserSex,
        buttonClickUserAgeDyna
    )
}

@Composable
private fun UserNameScreen(
    name: String,
    buttonClickUserSex: () -> Unit,
    buttonClickUserAgeDyna: () -> Unit,
) {
    Scaffold(
        content = {
            Content(
                Modifier.padding(it),
                name,
                buttonClickUserSex,
                buttonClickUserAgeDyna
            )
        }
    )
}

@Composable
private fun Content(
    modifier: Modifier,
    name: String,
    buttonClickUserSex: () -> Unit,
    buttonClickUserAgeDyna: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Welcome to the application..."
            )
            Greeting(name)
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { buttonClickUserSex() }
            ) {
                Text("View user sex")
            }
            Button(
                onClick = { buttonClickUserAgeDyna() }
            ) {
                Text("View user age (secret!)")
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Text(text = "You are $name!")
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    UserNameScreen(
        "Android",
        {},
        {}
    )
}