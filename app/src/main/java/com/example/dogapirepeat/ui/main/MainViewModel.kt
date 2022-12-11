package com.example.dogapirepeat.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapirepeat.data.remote.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _dogs = MutableLiveData<List<String>>()

    val dogs: LiveData<List<String>>
        get() = _dogs

    fun getDogImages(breed: String){
        viewModelScope.launch {
            _dogs.value = repository.loadDogs(breed)
        }
    }
}