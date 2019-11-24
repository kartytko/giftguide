package com.example.giftguide.api

import com.example.giftguide.domain.LoginDetails
import com.example.giftguide.infrastructure.postgres.UserDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class DummyAuthController {

    @Autowired
    lateinit var userDetailsRepository: UserDetailsRepository

    @PostMapping
    fun dummyAuth(@RequestBody loginDetails: LoginDetails): ResponseEntity<LoginDetails> {
        return ResponseEntity(LoginDetails(loginDetails.login), HttpStatus.OK)
    }

    //TODO: Delete v2 mapping.
    @PostMapping("/v2")
    fun auth(@RequestBody loginDetails: LoginDetails): ResponseEntity<LoginDetails> {
        val userDetails = userDetailsRepository.findById(loginDetails.login)
        return if (userDetails.isPresent && userDetails.get().password == loginDetails.password) {
            ResponseEntity(LoginDetails(loginDetails.login), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }
}


