package com.camachoyury.tshirtstore.network

import com.camachoyury.tshirtstore.ShirtResponse
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import io.ktor.client.request.*

class Api {

    private val client = HttpClient() {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
        install(JsonFeature) {
            val json = Json { isLenient = true; ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getTShirtList(): ShirtResponse {
        return client.get("https://run.mocky.io/v3/ef04c8ac-6e91-4059-9c62-b2de95b55c27")
    }


}