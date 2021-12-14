package com.exam.mercuriesdata_exam

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.exam.mercuriesdata_exam.databinding.RequestFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RequestDataFragment : Fragment(R.layout.request_fragment) {

    private val binding by viewBinding(RequestFragmentBinding::bind)

    private val viewModel by viewModels<RequestDataViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnRequest.setOnClickListener {
            viewModel.requestData(binding.tvName.text.toString())
        }

        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.requestSuccess.collect {
                    findNavController().navigate(
                        RequestDataFragmentDirections.actionRequestFragmentToDataListFragment()
                    )
                }
            }
        }
    }
}