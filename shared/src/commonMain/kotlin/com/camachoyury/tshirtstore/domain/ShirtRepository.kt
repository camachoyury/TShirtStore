package com.camachoyury.tshirtstore.domain

import com.camachoyury.tshirtstore.data.Shirt
import kotlinx.coroutines.flow.Flow

interface ShirtRepository {
    fun getTShirtList(): Flow<List<Shirt>>

    fun getTShirtList(id: String ): Flow<Shirt>
}