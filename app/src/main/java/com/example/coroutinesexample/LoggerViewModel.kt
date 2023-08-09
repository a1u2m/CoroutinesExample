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

    fun addLog(msg: String) { //todo не нравится такая схема, триггерится только при изменении значения лд, а не изменении листа
        val tempList = _logs.value ?: mutableListOf()
        tempList.add(LogItem(msg))
        _logs.value = tempList
    }
}