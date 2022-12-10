package com.example.dogapirepeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogapirepeat.R
import com.example.dogapirepeat.data.model.Breed

class BreedAdapter() : RecyclerView.Adapter<BreedAdapter.ItemViewHolder>() {
    private var dataset = listOf<Breed>(
        Breed("Pug","https://images.dog.ceo//breeds//pug//n02110958_11239.jpg"),
        Breed("Beagle", "https://images.dog.ceo/breeds/beagle/n02088364_10108.jpg"),
        Breed("French Bulldog", "https://images.dog.ceo/breeds/bulldog-french/n02108915_1119.jpg"),
        Breed("Weimaraner", "https://images.dog.ceo/breeds/weimaraner/n02092339_284.jpg"),
    )

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

        holder.breedImage.setOnClickListener {
            //TODO
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}