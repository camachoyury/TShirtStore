package com.camachoyury.tshirtstore.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camachoyury.tshirtstore.domain.GetShirtList
import com.camachoyury.tshirtstore.data.Shirt
import com.camachoyury.tshirtstore.data.repository.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.databinding.FragmentSecondBinding
import com.camachoyury.tshirtstore.data.network.Api

class DetailFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
         id = arguments?.getString("id").toString()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val getShirtList = GetShirtList(ShirtRepositoryImpl(Api()))

        getShirtList.getCategory(id,
            success = {
                updateUI(it)
            },
            failure = ::handleError
        )
    }

    private fun updateUI(shirt: Shirt){
        binding.detailTitle.text = shirt.title
        binding.detailDescription.text = shirt.description
        binding.detailPrice.text = shirt.price.toString()
        val imageUri = "@drawable/${shirt.image}"
        val imageResource =
            resources.getIdentifier(imageUri, null, this.context?.packageName)
        binding.detailImage.setImageResource(imageResource)
    }

    private fun handleError(ex: Throwable?) {
        ex?.printStackTrace()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}