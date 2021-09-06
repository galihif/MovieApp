package com.giftech.movieapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmEntity (
    var id:Int,
    var title:String,
    var genre:String,
    var sinopsis:String,
    var poster:String
    ): Parcelable