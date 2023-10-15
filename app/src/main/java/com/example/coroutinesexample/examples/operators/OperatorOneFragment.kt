package com.example.coroutinesexample.examples.operators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentOperatorOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

class OperatorOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.operatorsCase1)
    }
    private lateinit var binding: FragmentOperatorOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperatorOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        lifecycleScope.launch {
            val asyncOne = async {
                loggerVM.addLog(resources.getString(R.string.operatorsCase1Action1))
                delay(2000)
                loggerVM.addLog(resources.getString(R.string.operatorsCase1Action2))
                1
            }
            val asyncTwo = async {
                loggerVM.addLog(resources.getString(R.string.operatorsCase1Action3))
                delay(3000)
                loggerVM.addLog(resources.getString(R.string.operatorsCase1Action4))
                2
            }

            val result = select {
                asyncOne.onAwait {
                    it
                }

                asyncTwo.onAwait {
                    it
                }
            }
            loggerVM.addLog(resources.getString(R.string.operatorsCase1Action5, result))
        }
    }
}