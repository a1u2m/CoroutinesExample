package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DispatcherOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.dispatchersCase1)
    }
    private lateinit var binding: FragmentDispatcherOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonWithoutDispatcher.setOnClickListener {
            testWithoutDispatcher()
        }
        binding.buttonWithDispatcher.setOnClickListener {
            testWithDispatcher()
        }
    }

    private fun testWithoutDispatcher() {
        val scope = CoroutineScope(Job())
        scope.launch {
            logActions(scope)
            loggerVM.addLog(resources.getString(R.string.dispatchersCase1WithoutDispatcherDesc))
        }
    }

    private fun testWithDispatcher() {
        val scope = CoroutineScope(Dispatchers.Main + Job())
        scope.launch {
            logActions(scope)
            loggerVM.addLog(resources.getString(R.string.dispatchersCase1WithDispatcherDesc))
        }
    }

    private fun logActions(scope: CoroutineScope) {
        loggerVM.addLog(resources.getString(R.string.dispatchersCase1Action1))
        loggerVM.addLog(resources.getString(R.string.dispatchersCase1Action2))
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase1Action3,
                scope.coroutineContext
            )
        )
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase1Action4,
                Thread.currentThread().name
            )
        )
    }
}