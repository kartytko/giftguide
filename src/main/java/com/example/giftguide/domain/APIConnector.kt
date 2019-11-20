package com.example.giftguide.domain

interface APIConnector {
    fun fetchItemDetails(itemId: String): ItemDetails
}