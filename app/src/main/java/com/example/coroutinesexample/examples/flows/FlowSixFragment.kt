package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSixBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FlowSixFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase6)
    }
    lateinit var binding: FragmentFlowSixBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSixBinding.inflate(inflater, container, false)
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
            flowOf(
                "aaA",
                "BbB",
                "ccc",
                "dDD",
                "eeE",
                "fFF",
                "ggg",
                "HHH",
                "iii",
                "jjj"
            ).uppercase().collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase6Action1, it.uppercase()))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun Flow<String>.uppercase(): Flow<String> = flow {
        collect {
            emit(it.uppercase())
        }
    }
}