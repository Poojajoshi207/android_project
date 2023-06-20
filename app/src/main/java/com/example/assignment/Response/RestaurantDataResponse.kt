package com.example.assignment.Response

import com.example.assignment.Model.Businesses
import com.example.assignment.Model.Region
import com.google.gson.annotations.SerializedName

data class RestaurantDataResponse (

    @SerializedName("businesses" ) var businesses : List<Businesses> ,
    @SerializedName("total"      ) var total      : Int?                  = null,
    @SerializedName("region"     ) var region     : Region?               = Region()

)