package com.example.marketclient.components

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView

class GroceryTextView(
    context: Context,
    private val groceryText: String,
): AppCompatTextView(context) {
    init {
        this.textSize = 20F
        this.text = groceryText
    }
}