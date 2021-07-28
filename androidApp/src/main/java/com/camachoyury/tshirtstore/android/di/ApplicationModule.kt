package com.camachoyury.tshirtstore.android.di

import android.app.Application
import android.content.Context
import com.camachoyury.tshirtstore.android.data.network.ShirtService
import com.camachoyury.tshirtstore.android.data.repository.ShirtRepositoryImpl
import com.camachoyury.tshirtstore.android.data.repository.ShirtRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideBaseUrl(): String = "https://run.mocky.io/v3/ef04c8ac-6e91-4059-9c62-b2de95b55c27/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, url: String ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideShirtRepository(
        photosService: ShirtService
    ): ShirtRepository {
        return ShirtRepositoryImpl(photosService)
    }

    @Provides
    @Singleton
    fun provideShirtService(retrofit: Retrofit): ShirtService =  retrofit.create(ShirtService::class.java)

}