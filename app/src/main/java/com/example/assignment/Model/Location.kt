package com.example.assignment.Model

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("address1"        ) var address1       : String?           = null,
    @SerializedName("address2"        ) var address2       : String?           = null,
    @SerializedName("address3"        ) var address3       : String?           = null,
    @SerializedName("city"            ) var city           : String?           = null,
    @SerializedName("zip_code"        ) var zipCode        : String?           = null,
    @SerializedName("country"         ) var country        : String?           = null,
    @SerializedName("state"           ) var state          : String?           = null,
    @SerializedName("display_address" ) var displayAddress : ArrayList<String> = arrayListOf()
)
