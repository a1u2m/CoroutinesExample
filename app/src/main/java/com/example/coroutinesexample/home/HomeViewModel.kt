package com.example.coroutinesexample.home

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
        val temp = mutableListOf<HomeItemModel>()
        temp.add(HomeItemModel.HomeTitleItem(R.string.titleDispatchers))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1, R.id.toDispatchersOne))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase2, R.id.toDispatchersTwo))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase3, R.id.toDispatchersThree))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase4, R.id.toDispatchersFour))
        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase5, R.id.toDispatchersFive))
        _items.value = temp
    }

}