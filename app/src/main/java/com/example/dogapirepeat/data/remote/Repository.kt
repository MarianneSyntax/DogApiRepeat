package com.example.dogapirepeat.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogapirepeat.data.model.Breed
import com.example.dogapirepeat.data.model.Response

class Repository {

    var dataset = listOf<Breed>(
        Breed("Pug","https://images.dog.ceo//breeds//pug//n02110958_11239.jpg"),
        Breed("Beagle", "https://images.dog.ceo/breeds/beagle/n02088364_10108.jpg"),
        // Breed("French Bulldog", "https://images.dog.ceo/breeds/bulldog-french/n02108915_1119.jpg"),
        Breed("Weimaraner", "https://images.dog.ceo/breeds/weimaraner/n02092339_727.jpg"),
    )


    private val _dogImages = MutableLiveData<List<String>>()

    val dogImages: LiveData<List<String>>
        get() = _dogImages

    suspend fun loadDogs(breed: String){
        val response: Response = ApiService.DogApi.retrofitService.getDogPics(breed)
        _dogImages.value = response.dogList
    }
}