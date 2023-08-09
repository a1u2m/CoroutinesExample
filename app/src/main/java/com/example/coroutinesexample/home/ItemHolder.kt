package com.example.coroutinesexample.home

import com.example.coroutinesexample.databinding.HomeItemItemBinding

class ItemHolder(val binding: HomeItemItemBinding) : BaseHomeHolder(binding.root) {
    override fun bind(itemData: HomeItemModel) {
        itemData as HomeItemModel.HomeItemItem
        binding.description.text = binding.root.context.getString(itemData.description)
        binding.button.setOnClickListener { itemData.buttonClick }
    }
}