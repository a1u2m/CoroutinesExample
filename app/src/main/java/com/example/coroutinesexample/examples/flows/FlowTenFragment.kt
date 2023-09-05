package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch

class FlowTenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase10)
    }
    private lateinit var binding: FragmentFlowTenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTenBinding.inflate(inflater, container, false)
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
            val flow = channelFlow {
                launch {
                    delay(1000)
                    send(1)
                }
                launch {
                    delay(2000)
                    send(2)
                }
                launch {
                    delay(3000)
                    send(3)
                }
            }
            flow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase10Action1, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase10Action2))
        }
    }
}