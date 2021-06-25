package com.camachoyury.tshirtstore

import com.camachoyury.tshirtstore.network.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ShirtRepositoryImpl(private val api: Api) {

     fun getTShirtList(): Flow<List<Shirt>> {
        return flow {
            emit(api.getTShirtList().shirt)
        }.flowOn(ApplicationDispatcher)
    }


    fun getTShirtList(id:String ): Flow<Shirt> {
        return flow {
            val shirt = api.getTShirtList().shirt.find { s -> s.image == id }
            emit(shirt!!)
        }.flowOn(ApplicationDispatcher)
    }
}