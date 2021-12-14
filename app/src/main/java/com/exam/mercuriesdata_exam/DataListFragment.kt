package com.exam.mercuriesdata_exam

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.exam.mercuriesdata_exam.databinding.DataListFragmentBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DataListFragment : Fragment(R.layout.data_list_fragment) {

    private val binding by viewBinding(DataListFragmentBinding::bind)

    private val viewModel by viewModels<DataListViewModel>()

    private val dataAdapter = DataAdapter { apodSite ->
        findNavController().navigate(
            DataListFragmentDirections.actionDataListFragmentToWebViewFragment(apodSite)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getListData()
        binding.rvDataList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dataAdapter
            val divider = MaterialDividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            ).apply {
                dividerThickness = 4
            }
            addItemDecoration(divider)
        }
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listData.collect {
                    dataAdapter.submitList(it)
                }
            }
        }
    }
}