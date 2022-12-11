package com.example.dogapirepeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogapirepeat.R
import com.example.dogapirepeat.data.model.Breed
import com.example.dogapirepeat.data.remote.Repository
import com.example.dogapirepeat.ui.main.MainFragmentDirections

class MainAdapter() : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {
    private var repo = Repository()
    private var dataset = repo.dataset


    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val breedImage: ImageView = view.findViewById(R.id.breed_coverImg)
        val breedName: TextView = view.findViewById(R.id.breed_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.breed_item,parent,false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Breed = dataset[position]
        // coil, um jeweils die Bilder mit .load() reinzuladen:
        holder.breedImage.load(item.imageResource)
        holder.breedName.text = item.name
        val breedKey: String = item.name.lowercase()

        holder.breedImage.setOnClickListener {
            holder.itemView.findNavController().navigate(MainFragmentDirections.actionMainFragmentToBreedFragment(breedKey))
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}