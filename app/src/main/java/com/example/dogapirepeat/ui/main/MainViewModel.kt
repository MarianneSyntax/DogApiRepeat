package com.example.dogapirepeat.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapirepeat.data.remote.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()
    val dogs: LiveData<List<String>>
        get() = repository.dogImages

    fun getDogImages(breed: String){
        viewModelScope.launch {
            repository.loadDogs(breed)
        }
    }
}