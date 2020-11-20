package com.example.marketclient.networking

import kotlinx.serialization.Serializable

@Serializable
class AddGroceryPayload(
        var qrUrl: String? = null,
        var id: String? = null
) {}
