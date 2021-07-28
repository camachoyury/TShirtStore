package com.camachoyury.tshirtstore.android.data.repository

import com.camachoyury.tshirtstore.android.data.repository.Shirt
import kotlinx.coroutines.flow.Flow

interface ShirtRepository {

    fun getTShirtById(): Flow<List<Shirt>>

    fun getTShirtById(id: String ): Flow<Shirt>

}