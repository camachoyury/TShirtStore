package com.camachoyury.tshirtstore.android.domain.repository

import com.camachoyury.tshirtstore.android.data.repository.Shirt
import kotlinx.coroutines.flow.Flow

interface ShirtRepository {

    fun getTShirts(): Flow<List<Shirt>>

    fun getTShirtById(id: String ): Flow<Shirt>

}