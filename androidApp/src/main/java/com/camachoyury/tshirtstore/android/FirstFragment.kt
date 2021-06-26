package com.camachoyury.tshirtstore.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camachoyury.tshirtstore.GetShirtList
import com.camachoyury.tshirtstore.Injector
import com.camachoyury.tshirtstore.Shirt
import com.camachoyury.tshirtstore.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.databinding.FragmentFirstBinding
import com.camachoyury.tshirtstore.network.Api

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var  getShirtList:GetShirtList
    private var shirts: MutableList<Shirt> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         getShirtList = Injector.getShirtList
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
//        }


        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager( this.requireContext(),2)
        binding.recyclerViewShirts.layoutManager = layoutManager
        var adapter =  ShirtAdapter(shirts,context = this.requireContext()){
            val bundle = bundleOf("id" to it.image)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
        binding.recyclerViewShirts.adapter = adapter

        getShirtList.getCategoriesList(
            success = {
                adapter.setShirtList(it)

            },
            failure = ::handleError
        )
    }
    private fun handleError(ex: Throwable?) {

        ex?.printStackTrace()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}