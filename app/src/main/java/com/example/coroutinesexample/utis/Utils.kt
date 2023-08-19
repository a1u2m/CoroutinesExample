package com.example.coroutinesexample.utis

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Utils {

    @SuppressLint("SimpleDateFormat")
    fun getCurrentTime(): String {
        val currentTimeMillis = System.currentTimeMillis()
        val sdf = SimpleDateFormat("HH:mm:ss")
        val currentDate = Date(currentTimeMillis)
        return sdf.format(currentDate)
    }
}