package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class BuilderFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase4)
    }
    private lateinit var binding: FragmentBuilderFourBinding
    private val scope = CoroutineScope(Dispatchers.Default)
    lateinit var job: Job
    lateinit var deferred: Deferred<Unit>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLaunchCreate.setOnClickListener {
            launchCreate()
        }
        binding.buttonLaunchStart.setOnClickListener {
            launchStart()
        }

        binding.buttonAsyncCreate.setOnClickListener {
            asyncCreate()
        }
        binding.buttonAsyncStart.setOnClickListener {
            lifecycleScope.launch {
                asyncStart()
            }
        }
    }

    private fun launchCreate() {
        coroutineCreate()
        job = scope.launch(start = CoroutineStart.LAZY) {
            coroutineBody()
        }
        coroutineEndOfCreation()
    }

    private fun asyncCreate() {
        coroutineCreate()
        deferred = scope.async(start = CoroutineStart.LAZY) {
            coroutineBody()
        }
        coroutineEndOfCreation()
    }

    private fun launchStart() {
        coroutineStart()
        job.start()
        coroutineEnd()
    }

    private suspend fun asyncStart() {
        coroutineStart()
        deferred.await()
        coroutineEnd()
    }

    private fun coroutineCreate() {
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action1))
    }

    private fun coroutineEndOfCreation() {
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action2))
    }

    private fun coroutineBody() {
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action3))
        TimeUnit.MILLISECONDS.sleep(1000)
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action4))
    }

    private fun coroutineEnd() {
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action5))
    }

    private fun coroutineStart() {
        loggerVM.addLog(resources.getString(R.string.buildersCase4Action6))
    }
}