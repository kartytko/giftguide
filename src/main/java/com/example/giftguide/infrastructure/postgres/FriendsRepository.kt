package com.example.giftguide.infrastructure.postgres

import com.example.giftguide.domain.postgres.FriendsPostgres
import com.example.giftguide.domain.postgres.ItemDetailsPostgres
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendsRepository : CrudRepository<FriendsPostgres, String> {
    fun findByUserId(userId: String): Iterable<FriendsPostgres>
}