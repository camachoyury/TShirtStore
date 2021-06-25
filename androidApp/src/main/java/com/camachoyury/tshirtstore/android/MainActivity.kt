package com.camachoyury.tshirtstore.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.camachoyury.tshirtstore.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.camachoyury.tshirtstore.GetShirtList
import com.camachoyury.tshirtstore.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.databinding.ActivityMainBinding
import com.camachoyury.tshirtstore.network.Api
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.camachoyury.tshirtstore.Shirt


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var shirts: MutableList<Shirt> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getShirtList = GetShirtList(ShirtRepositoryImpl(Api()))
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recyclerViewShirts.layoutManager = layoutManager
        var adapter =  ShirtAdapter(shirts,context = this){

        }
        binding.recyclerViewShirts.adapter =adapter

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
}
