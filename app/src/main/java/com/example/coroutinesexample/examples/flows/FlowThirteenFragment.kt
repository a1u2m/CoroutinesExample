package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowThirteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utils.Utils
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FlowThirteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase13)
    }
    private lateinit var binding: FragmentFlowThirteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowThirteenBinding.inflate(inflater, container, false)
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
            flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).buffer(2, BufferOverflow.DROP_OLDEST).collect {
                delay(1000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.flowsCase13Action1,
                        it,
                        Utils.getCurrentTime()
                    )
                )
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase13Action2))
        }
    }
}