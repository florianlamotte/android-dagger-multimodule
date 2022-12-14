package com.nurokron.android.useragedynamicmodule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nurokron.android.feature.standard.theme.DaggerMultimoduleTheme

@Composable
fun UserAgeView(
    viewModel: UserAgeViewModel,
) {
    val user by viewModel.user.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Text(
                "This screen shows the user age... It's a dynamic module, as not everyone " +
                        "wants to see their age."
            )
            UserData(
                user.name,
                user.age.toString()
            )
        }
    }
}

@Composable
fun UserData(
    name: String,
    age: String
) {
    Text(text = "User: $name - Age: $age")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerMultimoduleTheme {
        UserData(
            "Android",
            "10"
        )
    }
}