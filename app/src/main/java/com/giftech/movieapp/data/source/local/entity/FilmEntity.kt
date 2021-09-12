package com.giftech.movieapp.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "filmentities")
data class FilmEntity (


    var id:Int?,
    var title:String?,
    var genre:String?,
    var sinopsis:String?,
    var poster:String?,
    var bookmarked:Int?,
    var type:Int? //0 for movie 1 for tv
    ): Parcelable