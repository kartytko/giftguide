package com.example.giftguide.api

import com.example.giftguide.domain.LoginDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class DummyAuthController {

    @PostMapping
    fun dummyAuth(@RequestBody loginDetails: LoginDetails): ResponseEntity<LoginDetails> {
        return ResponseEntity(LoginDetails(loginDetails.login), HttpStatus.OK)
    }
}


