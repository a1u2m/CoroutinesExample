package com.example.coroutinesexample.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseHomeHolder(val view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(itemData: HomeItemModel) {}
}