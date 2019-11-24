package com.example.giftguide.domain.postgres

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class UserDetailsPostgres(
        @Id
        val login: String,
        val password: String,
        val name: String,
        val surname: String,
        val mail: String,
        val photoUrl: String? = null

) {

    constructor() : this("", "","", "", "","")
}