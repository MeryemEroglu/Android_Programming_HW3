package com.meryemeroglu.hwapi.service

import com.meryemeroglu.hwapi.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    fun getCountries(): Call<List<Product>>
}