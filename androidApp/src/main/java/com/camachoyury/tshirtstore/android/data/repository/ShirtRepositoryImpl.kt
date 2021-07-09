package com.camachoyury.tshirtstore.android.data.repository

import com.camachoyury.tshirtstore.android.data.network.Api
import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ShirtRepositoryImpl(private val api: Api) : ShirtRepository {

     override fun getTShirtList(): Flow<List<Shirt>> {
        return flow {
            emit(api.getTShirtList().shirt)
        }.flowOn(Dispatchers.IO)
    }


    override  fun getTShirtList(id: String ): Flow<Shirt> {
        return flow {
            val shirt = api.getTShirtList().shirt.find { s -> s.image == id }
            emit(shirt!!)
        }.flowOn(Dispatchers.IO)
    }
}