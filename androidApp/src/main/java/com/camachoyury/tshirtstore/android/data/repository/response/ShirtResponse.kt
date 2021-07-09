package com.camachoyury.tshirtstore.android.data.repository.response

import com.camachoyury.tshirtstore.android.data.repository.Shirt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShirtResponse(
    @SerialName("shirts")
    val shirt: List<Shirt>
    )