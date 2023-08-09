package com.example.coroutinesexample.home

import android.view.View.OnClickListener
import androidx.annotation.StringRes

sealed class HomeItemModel {

    data class HomeTitleItem(
        @StringRes val title: Int
    ) : HomeItemModel()

    data class HomeItemItem(
        @StringRes val description: Int,
        val buttonClick: OnClickListener
    ) : HomeItemModel()
}