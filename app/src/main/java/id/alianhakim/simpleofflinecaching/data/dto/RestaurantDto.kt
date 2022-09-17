package id.alianhakim.simpleofflinecaching.data.dto


import com.google.gson.annotations.SerializedName

data class RestaurantDto(
    @SerializedName("building_number")
    val buildingNumber: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("city_prefix")
    val cityPrefix: String,
    @SerializedName("city_suffix")
    val citySuffix: String,
    @SerializedName("community")
    val community: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("full_address")
    val fullAddress: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("mail_box")
    val mailBox: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("secondary_address")
    val secondaryAddress: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("state_abbr")
    val stateAbbr: String,
    @SerializedName("street_address")
    val streetAddress: String,
    @SerializedName("street_name")
    val streetName: String,
    @SerializedName("street_suffix")
    val streetSuffix: String,
    @SerializedName("time_zone")
    val timeZone: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("zip")
    val zip: String,
    @SerializedName("zip_code")
    val zipCode: String
)