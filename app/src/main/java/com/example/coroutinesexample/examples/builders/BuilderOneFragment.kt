package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BuilderOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase1)
    }
    private lateinit var binding: FragmentBuilderOneBinding
    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase1Action1))
            val deferred = async {
                loggerVM.addLog(resources.getString(R.string.buildersCase1Action2))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase1Action3))
                resources.getString(R.string.buildersCase1Action4)
            }
            loggerVM.addLog(resources.getString(R.string.buildersCase1Action5))
            val result = deferred.await()
            loggerVM.addLog(resources.getString(R.string.buildersCase1Action6, result))
            loggerVM.addLog(resources.getString(R.string.buildersCase1Action7))
        }
    }
}