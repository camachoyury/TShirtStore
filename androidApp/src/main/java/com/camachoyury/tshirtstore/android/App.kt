package com.camachoyury.tshirtstore.android

import android.app.Application
import com.camachoyury.tshirtstore.android.data.repository.Shirt
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object{
        val emulatedDB = mutableListOf<Shirt>()
    }
}