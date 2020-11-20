package com.example.marketclient.components

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.setPadding

class GroceryTextView(
    context: Context,
    private val groceryText: String,
): AppCompatTextView(context) {
    init {
        this.textSize = 16F
        this.text = groceryText
        this.setPadding(15)
    }
}