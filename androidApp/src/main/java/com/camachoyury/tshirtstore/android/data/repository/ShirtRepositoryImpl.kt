package com.camachoyury.tshirtstore.android.data.repository

import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ShirtRepositoryImpl @Inject constructor (private val shirtService: ShirtService) :
    ShirtRepository {

     override fun getTShirts(): Flow<List<Shirt>> {
        return flow {
            emit(shirtService.getShirts().shirts)
        }.flowOn(Dispatchers.IO)
    }

    override  fun getTShirtById(id: String ): Flow<Shirt> {
        return flow {
            val shirt = shirtService.getShirts().shirts.find { s -> s.image == id }
            emit(shirt!!)
        }.flowOn(Dispatchers.IO)
    }
}