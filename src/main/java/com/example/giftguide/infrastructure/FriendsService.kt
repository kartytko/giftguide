package com.example.giftguide.infrastructure

import com.example.giftguide.domain.ExtendedUserDetails
import com.example.giftguide.domain.FriendsDetails
import com.example.giftguide.domain.postgres.FriendsPostgres
import com.example.giftguide.domain.postgres.UserDetailsPostgres
import com.example.giftguide.infrastructure.postgres.FriendsRepository
import com.example.giftguide.infrastructure.postgres.UserDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FriendsService {

    @Autowired
    lateinit var friendsRepository: FriendsRepository

    fun getAllFriends(userId: String): List<FriendsDetails> {
        return friendsRepository.findByUserId(userId).map { it.toFriendsDetails() }
    }

    fun FriendsPostgres.toFriendsDetails() = FriendsDetails(userId = this.userId, friendId = this.friendId)
}