package com.example.giftguide.infrastructure

import com.example.giftguide.domain.APIConnector
import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.Price
import org.springframework.stereotype.Component
import java.util.*

@Component
class SellerAPIConnector : APIConnector {
    override fun fetchItemDetails(itemId: String): ItemDetails {
        //TODO: Implement. Throw custom error if connection failed.
        return ItemDetails(id = "itemFromAPIId",
                displayName = "Item from API display name",
                category = "Category 54",
                price = Price(
                        amount = 300,
                        currency = Currency.getInstance("PLN")),
                redirectUrl = "redirect/link/to/item",
                photoUrl = "photo/url")
    }
}