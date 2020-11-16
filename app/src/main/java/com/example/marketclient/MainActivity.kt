package com.example.marketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.value
import kotlinx.android.synthetic.main.activity_main.plusButton
import kotlinx.android.synthetic.main.activity_main.minusButton
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var client = OkHttpClient()
    var request = OkHttpRequest(client)
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value.text = "" + id

        plusButton.setOnClickListener {
            value.text = "" + ++id
        }

        val callBackHome = object: Callback {
            override fun onResponse(call: Call, response: Response) {
                try {
                    if (response.isSuccessful) {
                        /*value.text = response.body.toString()*/
                        println(response.body?.string())
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

        minusButton.setOnClickListener {
            /*value.text = "" + --id*/
            request.GET(url, callBackHome)
        }
    }
}