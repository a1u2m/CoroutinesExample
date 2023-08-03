package com.example.coroutinesexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesexample.databinding.LoggerItemBinding

class LogsAdapter : RecyclerView.Adapter<LogsHolder>() {

    var items = mutableListOf<LogItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsHolder {
        return LogsHolder(
            LoggerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LogsHolder, position: Int) {
        holder.binding.body.text = items[position].body
    }
}