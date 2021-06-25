package com.camachoyury.tshirtstore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GetShirtList(private val shirtRepositoryImpl: ShirtRepositoryImpl) {

    private val coroutineScope: CoroutineScope = MainScope()

    fun getCategoriesList(success: (List<Shirt>) -> Unit, failure: (Throwable?) -> Unit) {
        coroutineScope.launch {
            try {
                shirtRepositoryImpl.getTShirtList().collect {
                    success(it)
                }
            } catch (e: Throwable) {
                failure(e)
            }
        }
    }

    fun getCategorie(string:String,  success: (Shirt) -> Unit, failure: (Throwable?) -> Unit) {
        coroutineScope.launch {
            try {
                shirtRepositoryImpl.getTShirtList(string).collect {
                    success(it)
                }
            } catch (e: Throwable) {
                failure(e)
            }
        }
    }

}