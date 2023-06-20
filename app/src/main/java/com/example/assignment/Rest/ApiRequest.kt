package com.example.assignment.Rest

import com.example.assignment.Response.RestaurantDataResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiRequest {
@GET("businesses/search")
    suspend fun getRestaurantDetail(@Header("Authorization") token: String,
                        @Query("location") restaurantId: String, @Query("limit") type: String,@Query("radius") radius:String): RestaurantDataResponse
}