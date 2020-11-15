package com.example.marketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.value
import kotlinx.android.synthetic.main.activity_main.plusButton
import kotlinx.android.synthetic.main.activity_main.minusButton

class MainActivity : AppCompatActivity() {
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value.text = "" + id

        plusButton.setOnClickListener {
            value.text = "" + ++id
        }

        minusButton.setOnClickListener {
            value.text = "" + --id
        }
    }
}