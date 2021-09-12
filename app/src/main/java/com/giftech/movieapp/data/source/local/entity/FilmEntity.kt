package com.giftech.movieapp.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "filmentities")
data class FilmEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int?,

    @ColumnInfo(name = "title")
    var title:String?,

    @ColumnInfo(name = "genre")
    var genre:String?,

    @ColumnInfo(name = "sinopsis")
    var sinopsis:String?,

    @ColumnInfo(name = "poster")
    var poster:String?,

    @ColumnInfo(name = "bookmarked")
    var bookmarked:Boolean?,

    @ColumnInfo(name = "isMovie")
    var isMovie:Boolean?

    ): Parcelable