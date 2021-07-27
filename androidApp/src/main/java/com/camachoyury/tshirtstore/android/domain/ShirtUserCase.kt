package com.camachoyury.tshirtstore.android.domain

import com.camachoyury.tshirtstore.android.data.repository.Shirt
import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShirtUserCase @Inject constructor(private val shirtRepository: ShirtRepository){

    operator fun invoke(id:String): Flow<Shirt> {

        return shirtRepository.getTShirtList(id)

    }

}