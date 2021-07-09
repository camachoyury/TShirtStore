package com.camachoyury.tshirtstore.android.domain.repository

import com.camachoyury.tshirtstore.android.data.repository.Shirt
import kotlinx.coroutines.flow.Flow

interface ShirtRepository {

    fun getTShirtList(): Flow<List<Shirt>>

    fun getTShirtList(id: String ): Flow<Shirt>

}