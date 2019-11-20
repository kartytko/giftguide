package com.example.giftguide.infrastructure

import com.example.giftguide.domain.APIConnector
import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.Price
import org.springframework.stereotype.Component
import java.util.*

@Component
class WishlistService(private val sellerAPIConnector: SellerAPIConnector) {
    fun getUserWishlist(userId: String): List<ItemDetails> {
        //TODO: Fetch customized wishlist and the default one (which is directly connected to provider's API). Merge them and return.
        val items = listOf(
                ItemDetails(
                        displayName = "testDisplayName",
                        category = "testCategory",
                        price = Price(100, Currency.getInstance("PLN")),
                        redirectUrl = "http://redirect.to/some/page",
                        photoUrl = "/test/url.jpg"
                ),
                ItemDetails(
                        displayName = "testDisplayName2",
                        category = "testCategory2",
                        price = Price(200, Currency.getInstance("PLN")),
                        redirectUrl = null,
                        photoUrl = "/test2/url2.png"
                )
        )
        return items
    }

    fun addCustomItemToWishlist(userId: String, customItem: ItemDetails): ItemDetails {
        // TODO: Add an item into database and fetch its new id.
        val customItemWithId = customItem.copy("randomId")
        return customItemWithId
    }

    //
    fun addItemToWishlist(userId: String, itemId: String): ItemDetails {
        // TODO: Fetch item from API to check if it exists. Handle custom error and return accordingly.
        val fetchedItem = sellerAPIConnector.fetchItemDetails(itemId)

        // TODO: If so, add itemId into database for specific user.

        return fetchedItem
    }
}