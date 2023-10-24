package com.example.coroutinesexample.examples.scopefunctions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExampleFourViewModel : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String>
        get() = _liveData

    fun action() {
        viewModelScope.launch {
            for (i in 0..Long.MAX_VALUE) {
                _liveData.value = i.toString()
                delay(1000)
            }
        }
    }
}