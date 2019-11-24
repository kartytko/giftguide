package com.example.giftguide.api

import com.example.giftguide.domain.postgres.UserDetailsPostgres
import com.example.giftguide.infrastructure.postgres.UserDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
*
*  This endpoint is used to set dummy data into postgres.
*  Testing purposes only.
*
* */

@RestController
@RequestMapping("/setup")
class SetUpController {

    @Autowired
    lateinit var userDetailsRepository: UserDetailsRepository

    @PostMapping("/userdetails")
    fun tmp(@RequestBody body: UserDetailsPostgres) {
        userDetailsRepository.save(body)
    }
}

