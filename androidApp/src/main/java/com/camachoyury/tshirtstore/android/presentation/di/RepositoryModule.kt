package com.camachoyury.tshirtstore.android.presentation.di

import com.camachoyury.tshirtstore.android.data.repository.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.data.repository.ShirtService
import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
 object RepositoryModule {

    @Provides
      fun getShirtRepository(shirtService: ShirtService): ShirtRepository {
        return  ShirtRepositoryImpl(shirtService)
     }

    @Provides
    fun provideShirtService(retrofit: Retrofit): ShirtService {
        return retrofit.create(ShirtService::class.java)
    }
}