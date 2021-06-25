package com.camachoyury.tshirtstore

import com.camachoyury.tshirtstore.network.Api

object Injector {

    private val api : Api by lazy { return@lazy Api() }

    private val shirtRepositoryImpl: ShirtRepositoryImpl by lazy { return@lazy  ShirtRepositoryImpl(api) }

    val getShirtList: GetShirtList by lazy { return@lazy  GetShirtList(shirtRepositoryImpl) }

}