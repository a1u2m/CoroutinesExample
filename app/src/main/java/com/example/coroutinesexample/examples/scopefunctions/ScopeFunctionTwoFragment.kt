package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScopeFunctionTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase3)
    }
    private lateinit var binding: FragmentScopefunctionTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase2Action1))
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase2Action2,
                    coroutineContext
                )
            )
            delay(1000)
            withContext(Dispatchers.Main) {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase2Action3))
                delay(1000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.scopeFunctionsCase2Action2,
                        coroutineContext
                    )
                )
                withContext(Dispatchers.IO) {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase2Action4))
                    delay(1000)
                    loggerVM.addLog(
                        resources.getString(
                            R.string.scopeFunctionsCase2Action2,
                            coroutineContext
                        )
                    )
                }
            }
        }
    }
}