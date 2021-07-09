package com.camachoyury.tshirtstore.android.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camachoyury.tshirtstore.android.R
import com.camachoyury.tshirtstore.android.domain.ShirtListUserCase
import com.camachoyury.tshirtstore.android.data.repository.Shirt

import com.camachoyury.tshirtstore.android.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var shirts: MutableList<Shirt> = ArrayList()
    lateinit var adapter: ShirtAdapter

    private val viewModel: ShirtListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.load()
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager( this.requireContext(),2)
        binding.recyclerViewShirts.layoutManager = layoutManager
        adapter =  ShirtAdapter(shirts,context = this.requireContext()){
            val bundle = bundleOf("id" to it.image)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }

        binding.recyclerViewShirts.adapter = adapter
        lifecycleScope.launch {
            viewModel.shirtList.collect { uiState ->
                when(uiState){
                    is ShirtListState.Success -> adapter.setShirtList(uiState.shirts)
                    is ShirtListState.Error -> handleError(uiState.exception)
                }
            }
        }
    }

    private fun handleError(ex: Throwable?) {
        ex?.printStackTrace()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}