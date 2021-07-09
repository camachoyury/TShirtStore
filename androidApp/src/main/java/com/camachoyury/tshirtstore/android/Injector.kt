package com.camachoyury.tshirtstore.android

import com.camachoyury.tshirtstore.android.data.network.Api
import com.camachoyury.tshirtstore.android.data.repository.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.domain.ShirtListUserCase


object Injector {

    private val api : Api by lazy { return@lazy Api() }

    private val shirtRepositoryImpl: ShirtRepositoryImpl by lazy { return@lazy  ShirtRepositoryImpl(
        api
    ) }

    val SHIRT_LIST_USER_CASE: ShirtListUserCase by lazy { return@lazy  ShirtListUserCase(shirtRepositoryImpl) }

}