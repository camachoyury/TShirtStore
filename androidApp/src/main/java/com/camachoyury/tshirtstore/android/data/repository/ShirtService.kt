package com.camachoyury.tshirtstore.android.data.repository

import com.camachoyury.tshirtstore.android.data.repository.response.ShirtResponse
import retrofit2.http.GET

interface ShirtService {

    @GET("./")
    suspend fun getShirts(): ShirtResponse
}