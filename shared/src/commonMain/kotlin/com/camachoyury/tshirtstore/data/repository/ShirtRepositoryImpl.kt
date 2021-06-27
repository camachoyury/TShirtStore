package com.camachoyury.tshirtstore.data.repository

import com.camachoyury.tshirtstore.common.ApplicationDispatcher
import com.camachoyury.tshirtstore.data.Shirt
import com.camachoyury.tshirtstore.data.network.Api
import com.camachoyury.tshirtstore.domain.ShirtRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ShirtRepositoryImpl(private val api: Api): ShirtRepository {

     override fun getTShirtList(): Flow<List<Shirt>> {
        return flow {
            emit(api.getTShirtList().shirt)
        }.flowOn(ApplicationDispatcher)
    }

    override fun getTShirtList(id: String ): Flow<Shirt> {
        return flow {
            val shirt = api.getTShirtList().shirt.find { s -> s.image == id }
            emit(shirt!!)
        }.flowOn(ApplicationDispatcher)
    }
}