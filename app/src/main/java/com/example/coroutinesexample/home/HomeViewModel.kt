package com.example.coroutinesexample.home

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinesexample.R

class HomeViewModel : ViewModel() {

    private val _items =
        MutableLiveData<MutableList<HomeItemModel>>().apply { value = mutableListOf() }
    val items: LiveData<MutableList<HomeItemModel>>
        get() = _items

    init {
        val temp = mutableListOf<HomeItemModel>() //todo в онклик навигацию прокинуть
        temp.add(HomeItemModel.HomeTitleItem(R.string.titleDispatchers))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1, {
            Log.d("topkek", "1")
        }))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1) {
            Log.d("topkek", "2")
        })
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1) {
            Log.d("topkek", "3")
        })
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1) {
            Log.d("topkek", "4")
        })
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1) {
            Log.d("topkek", "5")
        })
        _items.value = temp
    }

}