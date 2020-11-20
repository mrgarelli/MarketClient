package com.example.marketclient

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


class OkHttpRequest (
    private val client: OkHttpClient
) {

    fun GET(url: String, callback: Callback): Call {
        val request = Request.Builder()
            .url(url)
            .build()
        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    fun PUT(url: String, jsonBody: String, callback: Callback): Call {
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody: RequestBody = jsonBody.toRequestBody(mediaType)
        val request = Request.Builder()
                .url(url)
                .put(requestBody)
                .build()
        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }
}