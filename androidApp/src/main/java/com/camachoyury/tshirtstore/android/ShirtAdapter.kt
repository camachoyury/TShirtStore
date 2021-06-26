package com.camachoyury.tshirtstore.android

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camachoyury.tshirtstore.Shirt
import com.camachoyury.tshirtstore.android.databinding.ShirtItemBinding

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

    public fun setShirtList(listOfMovies: List<Shirt>) {
        this.listOfShirts = listOfMovies
        notifyDataSetChanged()
    }
    inner class ShirtViewHolder(var binding: ShirtItemBinding) :
        RecyclerView.ViewHolder(binding.root)

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

    interface OnItemClickListener {
        fun onItemClick(shirt: Shirt?)
    }
}
