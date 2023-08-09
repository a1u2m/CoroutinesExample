package com.example.coroutinesexample.home

import com.example.coroutinesexample.databinding.HomeTitleItemBinding

class HeaderHolder(private val binding: HomeTitleItemBinding) :
    BaseHomeHolder(binding.root) {

    override fun bind(itemData: HomeItemModel) {
        itemData as HomeItemModel.HomeTitleItem
        binding.title.text = binding.root.context.getString(itemData.title)
    }
}