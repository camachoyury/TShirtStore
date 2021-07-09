package com.camachoyury.tshirtstore.android.di

import android.app.Application
import android.content.Context
import com.camachoyury.tshirtstore.android.data.network.Api
import com.camachoyury.tshirtstore.android.data.repository.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.domain.ShirtListUserCase
import com.camachoyury.tshirtstore.android.domain.repository.ShirtRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideApi() : Api = Api()


    @Provides
    @Singleton
    fun provideShirtRepository(api: Api) : ShirtRepository{
        return ShirtRepositoryImpl(api = api)

    }

    @Provides
    @Singleton
    fun provideShirtUseCase(shirtRepository: ShirtRepository) : ShirtListUserCase{
        return ShirtListUserCase(shirtRepository)

    }


}