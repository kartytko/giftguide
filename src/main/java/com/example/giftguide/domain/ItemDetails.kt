package com.example.giftguide.domain

import java.util.Currency

data class ItemDetails(val id: String? = null, val displayName: String, val category: String, val price: Price, val redirectUrl: String? = null, val photoUrl: String? = null)
data class CustomItemDetails(val id: String? = null, val displayName: String, val category: String, val price: Price, val photoUrl: String? = null)

data class Price(val amount: Int, val currency: Currency)
