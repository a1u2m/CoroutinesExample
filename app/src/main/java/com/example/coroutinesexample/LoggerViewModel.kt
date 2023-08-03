package com.example.coroutinesexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoggerViewModel : ViewModel() {

    private val _logs = MutableLiveData<MutableList<LogItem>>().apply { value = mutableListOf() }
    val logs: LiveData<MutableList<LogItem>> //todo не отдавать наружу мутабельное
        get() = _logs

    fun clearLogs() {
        _logs.value = mutableListOf()
    }

    fun testFillItems() {
        val testList = _logs.value
        for (i in 1..10) {
            testList?.add(LogItem("Tag Дочерние корутины внутри родительских$i"))
        }
        _logs.value = testList!!
    }
}