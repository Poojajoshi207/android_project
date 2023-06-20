package com.example.myapplication.rest

import retrofit2.Retrofit
import com.example.myapplication.rest.RetrofitRequest
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest {
    private var retrofit: Retrofit? = null

    //users
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.yelp.com/v3/") //users
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}