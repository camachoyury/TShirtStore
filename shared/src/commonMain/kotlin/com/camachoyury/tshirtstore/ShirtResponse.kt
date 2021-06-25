package com.camachoyury.tshirtstore

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShirtResponse(
    @SerialName("shirts")
    val shirt: List<Shirt>
    )