package com.camachoyury.tshirtstore.android.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope

import com.camachoyury.tshirtstore.android.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailShirtViewModel by viewModels()
    var id = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
         id = arguments?.getString("id").toString()
        return binding.root
    }

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.loadById(id)
            viewModel.shirt.collect { uiState ->
                when(uiState){
                    is ShirtDetailState.Success -> {
                        binding.detailTitle.text = uiState.shirt.title
                        binding.detailDescription.text = uiState.shirt.description
                        binding.detailPrice.text = uiState.shirt.price.toString()
                        val imageUri = "@drawable/${uiState.shirt.image}"
                        val imageResource =
                            resources.getIdentifier(imageUri, null, this@DetailFragment.context?.packageName)
                        binding.detailImage.setImageResource(imageResource)
                    }
                    is ShirtDetailState.Error -> handleError(uiState.exception)
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