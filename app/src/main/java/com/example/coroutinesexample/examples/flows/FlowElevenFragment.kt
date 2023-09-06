package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowElevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class FlowElevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase11)
    }
    private lateinit var binding: FragmentFlowElevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowElevenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val flow = callbackFlow {
            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    s?.toString()?.let {
                        trySend(it)
                        if (it == CLOSE) cancel()
                    }
                }

            }
            binding.editText.addTextChangedListener(textWatcher)
            awaitClose {
                loggerVM.addLog(resources.getString(R.string.flowsCase11Action1))
                binding.editText.removeTextChangedListener(textWatcher)
            }
        }
        action(flow)
    }

    private fun action(flow: Flow<String>) {
        lifecycleScope.launch {
            flow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase11Action2, it))
            }
        }
    }

    companion object {
        const val CLOSE = "close"
    }
}