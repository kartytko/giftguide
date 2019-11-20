package com.example.giftguide.domain

data class LoginDetails(val login: String, val password: String? = null)

data class UserDetails(val name: String, val surname: String, val mail: String, val photoUrl: String)