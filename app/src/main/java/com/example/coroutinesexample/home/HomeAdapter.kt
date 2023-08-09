package com.example.coroutinesexample.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesexample.databinding.HomeItemItemBinding
import com.example.coroutinesexample.databinding.HomeTitleItemBinding

class HomeAdapter : RecyclerView.Adapter<BaseHomeHolder>() {

    var items = mutableListOf<HomeItemModel>()

    override fun onBindViewHolder(holder: BaseHomeHolder, position: Int) {
        holder.bind(items[position])

        if (holder is ItemHolder) {
            holder.binding.button.setOnClickListener {
                Log.d("topkek", "${items[position]}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeHolder {
        var holder = BaseHomeHolder(parent)
        when (viewType) {
            HEADER -> {
                holder = HeaderHolder(
                    HomeTitleItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ITEM -> {
                holder = ItemHolder(
                    HomeItemItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }

        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeItemModel.HomeTitleItem -> HEADER
            is HomeItemModel.HomeItemItem -> ITEM
        }
    }

    companion object {
        const val HEADER = 0
        const val ITEM = 1
    }


    override fun getItemCount(): Int = items.size
}