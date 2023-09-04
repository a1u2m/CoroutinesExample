package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utis.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class DispatcherTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.dispatchersCase2)
    }
    private lateinit var binding: FragmentDispatcherTwoBinding
    private val scope = CoroutineScope(Dispatchers.Default)
    private var allJobsCompleted = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        repeat(20) {
            val job = scope.launch {
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase2Action1,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                TimeUnit.MILLISECONDS.sleep(2000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase2Action2,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                TimeUnit.MILLISECONDS.sleep(2000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase2Action3,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                TimeUnit.MILLISECONDS.sleep(2000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase2Action4,
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
                                loggerVM.addLog(resources.getString(R.string.dispatchersCase2Action5))
                            }
                        }
                    }
                }
            }
        }
    }
}