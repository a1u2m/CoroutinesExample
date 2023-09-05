package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class DispatcherThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.dispatchersCase3)
    }
    private lateinit var binding: FragmentDispatcherThreeBinding
    private val scope = CoroutineScope(Dispatchers.IO)
    private var allJobsCompleted = false
    private val liveData = MutableLiveData<String>().apply {
        this.value = scope.coroutineContext[Job.Key]?.children?.count().toString()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
        liveData.observe(viewLifecycleOwner) {
            binding.counter.text = it
        }
    }

    private fun action() {
        repeat(100) {
            val job = scope.launch {
                liveData.postValue(
                    scope.coroutineContext.job.children.filter { isActive }.count().toString())
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase3Action1,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                TimeUnit.MILLISECONDS.sleep(5000)
                loggerVM.addLog(
                    resources.getString(
                        R.string.dispatchersCase3Action2,
                        it,
                        Thread.currentThread().name,
                        Utils.getCurrentTime()
                    )
                )
                liveData.postValue(scope.coroutineContext.job.children.filter { isActive }.count().toString())
            }
            job.invokeOnCompletion { throwable ->
                if (scope.coroutineContext.isActive && !allJobsCompleted) {
                    if (throwable == null) {
                        if (scope.coroutineContext.job.children.count { it.isActive } == 0) {
                            allJobsCompleted = true
                            scope.launch {
                                loggerVM.addLog(resources.getString(R.string.dispatchersCase3Action3))
                            }
                        }
                    }
                }
                liveData.postValue(scope.coroutineContext.job.children.count().toString())
            }
        }
    }
}