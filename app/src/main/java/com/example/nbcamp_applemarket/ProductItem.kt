package com.example.nbcamp_applemarket


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val user : String,
    val img : Int,
    val productName:String,
    val location:String,
    val productCost:Int,
    val countChat:Int,
    val countFav:Int,
    val detail:String

):Parcelable
