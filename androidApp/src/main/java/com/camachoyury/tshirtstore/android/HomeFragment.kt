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
import com.camachoyury.tshirtstore.domain.GetShirtList
import com.camachoyury.tshirtstore.Injector
import com.camachoyury.tshirtstore.data.Shirt
import com.camachoyury.tshirtstore.android.databinding.FragmentFirstBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    //Common class declaration GetShirtList
    private lateinit var  getShirtList: GetShirtList

    private var shirts: MutableList<Shirt> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //calling the Injector getting GetShirtList
        getShirtList = Injector.getShirtList

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager( this.requireContext(),2)
        binding.recyclerViewShirts.layoutManager = layoutManager
        var adapter =  ShirtAdapter(shirts,context = this.requireContext()){
            val bundle = bundleOf("id" to it.image)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
        binding.recyclerViewShirts.adapter = adapter
        //Request to get the Shirts List
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