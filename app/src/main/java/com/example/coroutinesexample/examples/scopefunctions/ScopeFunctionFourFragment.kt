package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase5)
    }
    private lateinit var binding: FragmentScopefunctionFourBinding
    private val viewModel: ExampleFourViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner) {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase4Action1, it))
        }
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        viewModel.action()
    }
}