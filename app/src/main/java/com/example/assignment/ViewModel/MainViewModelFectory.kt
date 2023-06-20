package com.example.assignment.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.View.MainActivity

class MainViewModelFactory(application: MainActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RestaurantViewModel::class.java)){
            return RestaurantViewModel(application = Application()) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}