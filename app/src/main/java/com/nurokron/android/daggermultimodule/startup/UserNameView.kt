package com.nurokron.android.daggermultimodule.startup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
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
    Scaffold(
        content = { Content(name) }
    )
}

@Composable
private fun Content(
    name: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
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
                onClick = { /*TODO*/ }
            ) {
                Text("View age")
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
    DaggerMultimoduleTheme {
        UserNameScreen("Android")
    }
}