package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowNineBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class FlowNineFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase9)
    }
    private lateinit var binding: FragmentFlowNineBinding
    private val wordsList = listOf(
        "Sponge",
        "Bob",
        "Sticker",
        "Computer",
        "Internet",
        "Paper",
        "List",
        "Column",
        "Number",
        "Code"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowNineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOnEach.setOnClickListener {
            actionOnEach()
        }
        binding.buttonOnStart.setOnClickListener {
            actionOnStart()
        }
        binding.buttonOnCompletion.setOnClickListener {
            actionOnCompletion()
        }
        binding.buttonOnEmpty.setOnClickListener {
            actionOnEmpty()
        }
        binding.buttonEach.setOnClickListener {
            actionEach()
        }
    }

    private fun actionOnEach() {
        lifecycleScope.launch {
            val flow = wordsList.asFlow()
            flow.onEach { loggerVM.addLog(resources.getString(R.string.flowsCase9Action2, it)) }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase9Action4, it))
                    delay(500)
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase9Action6))
        }
    }

    private fun actionOnStart() {
        lifecycleScope.launch {
            val flow = wordsList.asFlow()
            flow.onStart { loggerVM.addLog(resources.getString(R.string.flowsCase9Action1)) }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase9Action4, it))
                    delay(500)
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase9Action7))
        }
    }

    private fun actionOnCompletion() {
        lifecycleScope.launch {
            val flow = wordsList.asFlow()
            flow.onCompletion {
                loggerVM.addLog(
                    resources.getString(
                        R.string.flowsCase9Action3,
                        it
                    )
                )
            }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase9Action4, it))
                    delay(500)
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase9Action8))
        }
    }

    private fun actionOnEmpty() {
        lifecycleScope.launch {
            val flow = listOf<String>().asFlow()
            flow.onEmpty { loggerVM.addLog(resources.getString(R.string.flowsCase9Action5)) }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase9Action4, it))
                    delay(500)
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase9Action9))
        }
    }

    private fun actionEach() {
        lifecycleScope.launch {
            val flow = wordsList.asFlow()
            flow.onStart { loggerVM.addLog(resources.getString(R.string.flowsCase9Action1)) }
                .onEach { loggerVM.addLog(resources.getString(R.string.flowsCase9Action2, it)) }
                .onCompletion {
                    loggerVM.addLog(
                        resources.getString(
                            R.string.flowsCase9Action3,
                            it
                        )
                    )
                }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase9Action4, it))
                    delay(500)
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase9Action10))
        }
    }
}