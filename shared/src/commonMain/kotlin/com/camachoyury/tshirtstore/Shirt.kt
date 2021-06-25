package com.camachoyury.tshirtstore

import kotlinx.serialization.Serializable

@Serializable
data class Shirt ( val name : String,
                  val title : String,
                  val category : String,
                  val price : Double,
                  val description : String,
                  val image : String )