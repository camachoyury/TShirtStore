package com.camachoyury.tshirtstore.android.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.camachoyury.tshirtstore.android.databinding.ShirtItemBinding
import com.camachoyury.tshirtstore.android.data.repository.Shirt

class ShirtAdapter(
    private var listOfShirts: List<Shirt> = listOf(),
    private val context: Context,
    private val onItemClicked: (Shirt) -> Unit) :
    RecyclerView.Adapter<ShirtAdapter.ShirtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtViewHolder {
        val binding = ShirtItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ShirtViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfShirts.size

    @SuppressLint("NotifyDataSetChanged")
    public fun setShirtList(listOfMovies: List<Shirt>) {
        this.listOfShirts = listOfMovies
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShirtViewHolder, position: Int) {
        with(holder) {
            with(listOfShirts[position]) {
                binding.textName.text = title
                binding.textCategory.text = category
                binding.textPrice.text = "Price: ${price.toString()}"

                val imageUri = "@drawable/${image}"
                val imageResource =
                    context.resources.getIdentifier(imageUri, null, context.packageName)
                binding.shirtImage.setImageResource(imageResource)
                binding.root.setOnClickListener { onItemClicked(this) }
            }
        }
    }

    inner class ShirtViewHolder(var binding: ShirtItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onItemClick(shirt: Shirt?)
    }
}
