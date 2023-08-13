package com.example.coroutinesexample.home

import androidx.annotation.StringRes

sealed class HomeItemModel {

    data class HomeTitleItem(
        @StringRes val title: Int
    ) : HomeItemModel()

    data class HomeItemItem(
        @StringRes val description: Int,
        val navigationPath: Int
    ) : HomeItemModel()
}