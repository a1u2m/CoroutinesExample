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

        temp.add(HomeItemModel.HomeTitleItem(R.string.titleErrors))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleBuilders))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleSuspend))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleCoroutines))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleScope))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleScopeFunctions))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleChannels))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleFlow))


        temp.add(HomeItemModel.HomeTitleItem(R.string.titleOperators))

        _items.value = temp
    }

}