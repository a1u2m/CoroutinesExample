package com.example.coroutinesexample.examples

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.logger.LoggerViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseExampleFragment : Fragment() {

    abstract val description: String
    val loggerVM: LoggerViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            loggerVM.addLog(resources.getString(R.string.openExample, description))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.launch(Dispatchers.IO) {
            loggerVM.addLog(resources.getString(R.string.quitExample, description))
        }
    }
}