package id.alianhakim.simpleofflinecaching.data.remote

import id.alianhakim.simpleofflinecaching.data.Address
import retrofit2.http.GET

interface AddressApi {
    @GET("addresses")
    suspend fun getAddresses(): List<Address>
}