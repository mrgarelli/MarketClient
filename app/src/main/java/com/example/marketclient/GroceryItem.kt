package com.example.marketclient

import kotlinx.serialization.Serializable

@Serializable
class GroceryItem(
    var id: String,
    var qrUrl: String,
    var name: String,
    var price: String,
    var thumbnail: String
) {}
