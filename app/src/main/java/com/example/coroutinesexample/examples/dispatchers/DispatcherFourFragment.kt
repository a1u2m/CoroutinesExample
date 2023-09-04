package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utis.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class DispatcherFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.dispatchersCase4)
    }
    private lateinit var binding: FragmentDispatcherFourBinding
    private val scope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())
    private var allJobsCompleted = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        repeat(5) {
            val job = scope.launch {
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase4Action1,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                TimeUnit.MILLISECONDS.sleep(1000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase4Action2,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
            }
            job.invokeOnCompletion { throwable ->
                if (scope.coroutineContext.isActive && !allJobsCompleted) {
                    if (throwable == null) {
                        if (scope.coroutineContext.job.children.count { it.isActive } == 0) {
                            allJobsCompleted = true
                            scope.launch {
                                loggerVM.addLog(resources.getString(R.string.dispatchersCase4Action3))
                            }
                        }
                    }
                }
            }
        }
    }
}