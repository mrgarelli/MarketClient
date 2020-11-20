package com.example.marketclient.components

import android.content.Context
import android.util.AttributeSet
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.marketclient.GroceryItem

class GroceryRow(
    context: Context,
    private val groceryItem: GroceryItem,
): TableRow(context) {

    init {
        val nameTextView = GroceryTextView(context, groceryItem.name)
        val priceTextView = GroceryTextView(context, groceryItem.price)

        this.addView(nameTextView)
        this.addView(priceTextView)
    }
}