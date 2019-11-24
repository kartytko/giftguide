package com.example.giftguide.domain.postgres

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class ItemDetailsPostgres(
        val displayName: String,
        val category: String,
        val amount: Double,
        val currency: String,
        val userId: String,
        val id: String? = null,
        val redirectUrl: String? = null,
        val photoUrl: String? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val postgresId: Long = -1

) {

    constructor() : this("", "", 0.0, Currency.getInstance("PLN").toString(), "")
}