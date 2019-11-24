package com.example.giftguide.infrastructure.postgres


import com.example.giftguide.domain.postgres.UserDetailsPostgres
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserDetailsRepository : CrudRepository<UserDetailsPostgres, String> {
//    fun findByLastName(lastName: String): Iterable<UserDetailsPostgres>
}
