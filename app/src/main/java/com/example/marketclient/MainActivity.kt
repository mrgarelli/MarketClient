package com.example.marketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.addGroceryButton
import kotlinx.android.synthetic.main.activity_main.value
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class MainActivity : AppCompatActivity() {
    var client = OkHttpClient()
    var request = OkHttpRequest(client)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value.text = "hey"

        val callBackHome = object: Callback {
            override fun onResponse(call: Call, response: Response) {
                try {
                    if (response.isSuccessful) {
                        val jsonStr: String? = response.body?.string()
                        if (jsonStr != null) {
                            val groceries = Json.decodeFromString<MutableList<GroceryItem>>(jsonStr)
                            GlobalScope.launch(Dispatchers.Main) {
                                value.text = groceries[0].name
                            }
                        }
                    }
                } catch ( e: IOException ) {
                    e.printStackTrace()
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        }
        val url = "http://10.0.2.2:8080/"

        addGroceryButton.setOnClickListener {
            request.GET(url, callBackHome)
        }
    }
}