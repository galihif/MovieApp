package com.giftech.movieapp.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmEntity (
    var id:Int?=0,
    var title:String?="",
    var genre:String?="",
    var sinopsis:String?="",
    var poster:String?="",
    var isBookmarked:Boolean=false
    ): Parcelable