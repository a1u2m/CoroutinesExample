package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowNineteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FlowNineteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase19)
    }
    private lateinit var binding: FragmentFlowNineteenBinding
    private val sharedFlow = MutableSharedFlow<Int>(replay = 2)
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowNineteenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonEmit.setOnClickListener {
            emit()
        }
        binding.buttonSubscribe.setOnClickListener {
            collect()
        }
    }

    private fun emit() {
        lifecycleScope.launch {
            sharedFlow.emit(counter)
            counter++
        }
    }

    private fun collect() {
        lifecycleScope.launch(Dispatchers.IO) {
            sharedFlow.collect {
                loggerVM.addLog(
                    resources.getString(
                        R.string.flowsCase19Action1,
                        it,
                        Thread.currentThread().name
                    )
                )
            }
        }
    }
}