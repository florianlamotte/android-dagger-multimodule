package com.nurokron.android.domain.user

data class User(
    val name: String,
    val age: Int,
    val sex: Sex,
)

enum class Sex {
    FEMALE,
    MALE
}