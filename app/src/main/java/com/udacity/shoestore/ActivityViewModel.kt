package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ActivityViewModel: ViewModel() {

    val shoes = MutableLiveData<MutableList<Shoe>>()
    val name =  MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val company = MutableLiveData<String>("")
    val size = MutableLiveData(0.0)

    fun addShoe(){
       shoes.value?.add(Shoe(name.value?: "", size.value?: 0.0, company.value?: "", description.value?: ""))
    }

    init{
        shoes.value = mutableListOf<Shoe>()
        shoes.value?.add(Shoe("Gucci Must have",32.0, "Gucci", "You want it, you need it, you should have it!"))
        shoes.value?.add(Shoe("Working Boots",45.0, "Caterpilla", "be a dirty boy..."))

    }

}