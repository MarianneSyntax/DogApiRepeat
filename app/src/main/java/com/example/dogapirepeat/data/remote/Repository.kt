package com.example.dogapirepeat.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogapirepeat.data.model.Breed
import com.example.dogapirepeat.data.model.Response

class Repository {

    var dataset = listOf<Breed>(
        Breed("Pug","https://images.dog.ceo/breeds/pug/n02110958_12761.jpg"),
        Breed("Beagle", "https://images.dog.ceo/breeds/beagle/n02088364_10108.jpg"),
        Breed("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_3045.jpg"),
        Breed("Weimaraner", "https://images.dog.ceo/breeds/weimaraner/n02092339_727.jpg"),
        Breed("Dalmatian", "https://images.dog.ceo/breeds/dalmatian/cooper2.jpg"),
        Breed("Eskimo", "https://images.dog.ceo/breeds/eskimo/n02109961_853.jpg"),
        Breed("Husky", "https://images.dog.ceo/breeds/husky/n02110185_14597.jpg"),
        Breed("Keeshond", "https://images.dog.ceo/breeds/keeshond/n02112350_6952.jpg")

    )

    suspend fun loadDogs(breed: String): List<String> {
        val response: Response = ApiService.DogApi.retrofitService.getDogPics(breed)
        return response.dogList
    }
}