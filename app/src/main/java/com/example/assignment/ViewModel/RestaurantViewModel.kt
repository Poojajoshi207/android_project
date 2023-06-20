package com.example.assignment.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.example.assignment.Model.Businesses
import com.example.assignment.Repository.RestaurantRepo
import kotlinx.coroutines.flow.Flow
import com.example.assignment.Response.RestaurantDataResponse


class RestaurantViewModel (application: Application): AndroidViewModel(application){
    private  var rangRadius:String="2000"
    private val restaurantRepo: RestaurantRepo = RestaurantRepo()
   // private val userResponseLiveData: Flow<PagingData<Businesses>> =restaurantRepo.getListData(rangRadius)


  /*  fun getUserResponseLiveData(): Flow<PagingData<Businesses>> {
        return userResponseLiveData
    }*/

    fun getUserResponseLiveData(radius: String): Flow<PagingData<Businesses>> {
        return restaurantRepo.getListData(radius)
    }
/*
    fun getRadius(radius:String) {
        rangRadius=radius;
        restaurantRepo.getListData(rangRadius)
    }*/


}