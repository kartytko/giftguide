package com.example.giftguide.infrastructure

import com.example.giftguide.domain.ExtendedUserDetails
import com.example.giftguide.domain.UserDetails
import com.example.giftguide.domain.postgres.UserDetailsPostgres
import com.example.giftguide.infrastructure.postgres.ItemDetailsRepository
import com.example.giftguide.infrastructure.postgres.UserDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    lateinit var userDetailsRepository: UserDetailsRepository

    fun getUserDetails(userId: String): ExtendedUserDetails {
        return userDetailsRepository.findById(userId).get().toExtendedUserDetails()
    }

    fun UserDetailsPostgres.toExtendedUserDetails() = ExtendedUserDetails(name = this.name, surname = this.surname, mail = this.mail, photoUrl = this.photoUrl, login = this.login)
}