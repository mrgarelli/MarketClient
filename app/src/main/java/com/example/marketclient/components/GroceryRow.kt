package com.example.marketclient.components

import android.content.Context
import android.widget.TableRow
import android.widget.TextView
import com.example.marketclient.GroceryItem

class GroceryRow(
    context: Context,
    private val groceryItem: GroceryItem
): TableRow(context) {

    init {
        val nameTextView = GroceryTextView(context, groceryItem.name)
        val priceTextView = GroceryTextView(context, groceryItem.price)

        this.addView(nameTextView)
        this.addView(priceTextView)
    }
}