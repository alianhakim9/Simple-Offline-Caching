package id.alianhakim.simpleofflinecaching.data

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("id")
    val id: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("full_address")
    val fullAddress: String,
    @SerializedName("country_code")
    val countryCode: String,
)
