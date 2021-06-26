package com.camachoyury.tshirtstore.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camachoyury.tshirtstore.GetShirtList
import com.camachoyury.tshirtstore.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.databinding.FragmentSecondBinding
import com.camachoyury.tshirtstore.network.Api

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
                binding.detailTitle.text = it.title
                binding.detailDescription.text = it.description
                binding.detailPrice.text = it.price.toString()
                val imageUri = "@drawable/${it.image}"
                val imageResource =
                    resources.getIdentifier(imageUri, null, this.context?.packageName)
                binding.detailImage.setImageResource(imageResource)

            },
            failure = ::handleError
        )
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    private fun handleError(ex: Throwable?) {

        ex?.printStackTrace()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}