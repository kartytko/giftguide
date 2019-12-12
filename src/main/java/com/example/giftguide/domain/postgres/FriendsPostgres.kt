package com.example.giftguide.domain.postgres

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class FriendsPostgres(
        val userId: String,
        val friendId: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val postgresId: Long = -1

) {

    constructor() : this("", "")
}