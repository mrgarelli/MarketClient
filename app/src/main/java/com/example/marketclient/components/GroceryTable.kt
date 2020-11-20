package com.example.marketclient.components

import android.content.Context
import android.graphics.Color
import android.widget.TableLayout
import android.widget.TableRow
import androidx.core.view.setPadding
import com.example.marketclient.GroceryItem

class GroceryTable(
        private val groceries: MutableList<GroceryItem>,
        private val table: TableLayout,
        private val context: Context,
) {
    init {
        val groceryHeaderRow = TableRow(context)

        val nameHeaderTextView = GroceryTextView(context, "Grocery")
        val priceHeaderTextView = GroceryTextView(context, "Price")

        groceryHeaderRow.addView(nameHeaderTextView)
        groceryHeaderRow.addView(priceHeaderTextView)

        groceryHeaderRow.setBackgroundColor(Color.parseColor("#0079D6"))
        groceryHeaderRow.setPadding(5)

        this.table.addView(groceryHeaderRow)

        for (grocery: GroceryItem in this.groceries) {
            val groceryRow = GroceryRow(context, grocery)
            this.table.addView(groceryRow)
        }
    }
}