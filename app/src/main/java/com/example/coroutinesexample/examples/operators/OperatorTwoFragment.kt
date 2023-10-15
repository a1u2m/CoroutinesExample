package com.example.coroutinesexample.examples.operators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentOperatorTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay

class OperatorTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.operatorsCase2)
    }
    private lateinit var binding: FragmentOperatorTwoBinding

    @OptIn(ObsoleteCoroutinesApi::class)
    private val actorChannel = lifecycleScope.actor<Unit> {
        for (click in channel) {
            val data = getData()
            loggerVM.addLog(resources.getString(R.string.operatorsCase2Action1, data))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperatorTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        loggerVM.addLog(resources.getString(R.string.operatorsCase2Action2))
        actorChannel.trySend(Unit)
    }

    private suspend fun getData(): String {
        delay(5000)
        return resources.getString(R.string.operatorsCase2Action3)
    }
}