package com.example.dogapirepeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogapirepeat.BreedFragmentDirections
import com.example.dogapirepeat.R

class DogAdapter() : RecyclerView.Adapter<DogAdapter.ItemViewHolder>() {
    private var dataset = listOf<String>()

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val dogImage: ImageView = view.findViewById(R.id.dog_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.dog_item,parent,false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: String = dataset[position]
        holder.dogImage.load(item)

        holder.dogImage.setOnClickListener {
            holder.itemView.findNavController().navigate(BreedFragmentDirections.actionBreedFragmentToDetailFragment(item))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}