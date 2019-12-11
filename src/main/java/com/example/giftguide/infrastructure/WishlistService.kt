package com.example.giftguide.infrastructure

import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.Price
import com.example.giftguide.domain.postgres.ItemDetailsPostgres
import com.example.giftguide.infrastructure.postgres.ItemDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class WishlistService(private val sellerAPIConnector: SellerAPIConnector) {

    @Autowired
    lateinit var itemDetailsRepository: ItemDetailsRepository

    fun getUserWishlist(userId: String): List<ItemDetails> {
        val customizedItems = itemDetailsRepository.findByUserId(userId)
        System.out.println(customizedItems)

        //TODO: Fetch the default list (which is directly connected to provider's API) and merge it with customized one.
        return customizedItems.map { it.toItemDetails() }
    }

    fun addCustomItemToWishlist(userId: String, customItem: ItemDetails): ItemDetails {
        val insertedItem = itemDetailsRepository.save(customItem.toItemDetailsPostgres(userId))
        return insertedItem.toItemDetails()
    }

    //
    fun addItemToWishlist(userId: String, itemId: String): ItemDetails {
        // TODO: Fetch item from API to check if it exists. Handle custom error and return accordingly.
        val fetchedItem = sellerAPIConnector.fetchItemDetails(itemId)

        // TODO: If so, add itemId into database for specific user.

        return fetchedItem
    }

    private fun ItemDetailsPostgres.toItemDetails() = ItemDetails(this.id,
            this.displayName,
            this.category,
            Price(this.amount, Currency.getInstance(this.currency)),
            this.redirectUrl,
            this.photoUrl,
            this.postgresId)

    private fun ItemDetails.toItemDetailsPostgres(userId: String) = ItemDetailsPostgres(displayName = this.displayName,
            category = this.category,
            amount = this.price.amount,
            currency = this.price.currency.toString(),
            userId = userId,
            id = this.id,
            redirectUrl = this.redirectUrl,
            photoUrl = this.photoUrl)
}