package com.example.giftguide.infrastructure

import com.example.giftguide.domain.UserDetails
import org.springframework.stereotype.Component

@Component
class UserService {
    fun getUserDetails(userId: String): UserDetails {
        return UserDetails("testName", "testSurname", "testMail", "/test/photo/url.jpg")
    }
}