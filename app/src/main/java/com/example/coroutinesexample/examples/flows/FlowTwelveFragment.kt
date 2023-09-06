package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwelveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlowTwelveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase12)
    }
    private lateinit var binding: FragmentFlowTwelveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwelveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        loggerVM.addLog(
            resources.getString(
                R.string.flowsCase12Action1,
                Thread.currentThread().name
            )
        )
        lifecycleScope.launch {
            flowOf(1, 2, 3, 4, 5)
                .onEach {
                    delay(500)
                    loggerVM.addLog(
                        resources.getString(
                            R.string.flowsCase12Action2,
                            it,
                            Thread.currentThread().name
                        )
                    )
                }
                .flowOn(Dispatchers.IO)
                .filter { it % 2 == 0 }
                .onEach {
                    delay(500)
                    loggerVM.addLog(
                        resources.getString(
                            R.string.flowsCase12Action3,
                            it,
                            Thread.currentThread().name
                        )
                    )
                }
                .flowOn(Dispatchers.Main)
                .map { "$it a" }
                .onEach {
                    delay(500)
                    loggerVM.addLog(
                        resources.getString(
                            R.string.flowsCase12Action4,
                            it,
                            Thread.currentThread().name
                        )
                    )
                }
                .collect {
                    delay(500)
                    loggerVM.addLog(
                        resources.getString(
                            R.string.flowsCase12Action5,
                            it,
                            Thread.currentThread().name
                        )
                    )
                }
        }
    }
}