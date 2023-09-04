package com.example.coroutinesexample.examples.suspends

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentSuspendOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utis.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class SuspendOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.suspendCase1)
    }
    private lateinit var binding: FragmentSuspendOneBinding
    private val backgroundColors = mutableListOf<Drawable>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuspendOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundColors.apply {
            ResourcesCompat.getDrawable(resources, R.color.black, null)?.let { add(it) }
            ResourcesCompat.getDrawable(resources, R.color.grey, null)?.let { add(it) }
            ResourcesCompat.getDrawable(resources, R.color.darkGrey, null)?.let { add(it) }
            ResourcesCompat.getDrawable(resources, R.color.lightBlue, null)?.let { add(it) }
        }
        binding.buttonA.setOnClickListener {
            actionA()
        }
        binding.buttonB.setOnClickListener {
            actionB()
        }
    }

    private fun actionA() {
        CoroutineScope(Dispatchers.Main).launch {
            suspendFun()
        }
    }

    private suspend fun suspendFun() {
        loggerVM.addLog(
            resources.getString(
                R.string.suspendsCase1Action1,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
        delay(10000)
        loggerVM.addLog(
            resources.getString(
                R.string.suspendsCase1Action2,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
    }

    private fun actionB() {
        while (true) {
            val random = Random.nextInt(backgroundColors.size)
            if (binding.square.background != backgroundColors[random]) {
                binding.square.background = backgroundColors[random]
                break
            }
        }
    }
}