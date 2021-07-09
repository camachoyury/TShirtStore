package com.camachoyury.tshirtstore.android.domain

import com.camachoyury.tshirtstore.android.data.repository.Shirt

import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShirtListUserCase(private val shirtRepository: ShirtRepository) {


    operator fun invoke(): Flow<List<Shirt>> {
        return shirtRepository.getTShirtList()
        }

//
//    fun getCategory(string:String, success: (Shirt) -> Unit, failure: (Throwable?) -> Unit) {
//        coroutineScope.launch {
//            try {
//                shirtRepository.getTShirtList(string).collect {
//                    success(it)
//                }
//            } catch (e: Throwable) {
//                failure(e)
//            }
//        }
//    }

}