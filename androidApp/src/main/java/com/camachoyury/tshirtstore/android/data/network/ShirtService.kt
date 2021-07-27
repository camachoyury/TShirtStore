package com.camachoyury.tshirtstore.android.data.network

import com.camachoyury.tshirtstore.android.data.repository.response.ShirtResponse
import retrofit2.http.GET

interface ShirtService {
    @GET("?results=10")
    suspend fun getShirts(): ShirtResponse
}