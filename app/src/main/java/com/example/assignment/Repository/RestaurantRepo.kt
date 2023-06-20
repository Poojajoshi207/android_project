package com.example.assignment.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.assignment.Model.Businesses
import com.example.assignment.Response.RestaurantDataResponse
import com.example.assignment.Rest.ApiRequest
import com.example.myapplication.rest.RetrofitRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class RestaurantRepo {
    private val apiRequest: ApiRequest = RetrofitRequest.retrofitInstance?.create(ApiRequest::class.java)!!
    val userDetail: MutableLiveData<RestaurantDataResponse?>
        get() {
            val abc:String="Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"
           val data: MutableLiveData<RestaurantDataResponse?> = MutableLiveData<RestaurantDataResponse?>()
           /* apiRequest.getRestaurantDetail(abc,"New York","15").enqueue(object : Callback<RestaurantDataResponse?> {
                override fun onResponse(
                    call: Call<RestaurantDataResponse?>,
                    response: Response<RestaurantDataResponse?>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                       Log.d("pooja","pooja yes")
                    }
                }

                override fun onFailure(call: Call<RestaurantDataResponse?>, t: Throwable) {
                    data.setValue(null)
                    Log.d("pooja",""+t)


                }
            })*/
            return data

        }
    fun getListData(radius:String): Flow<PagingData<Businesses>> {
        return Pager(config = PagingConfig(pageSize = 10, maxSize = 200),
            pagingSourceFactory = {RestaurantPagingSource(apiRequest,radius)}).flow
    }



}