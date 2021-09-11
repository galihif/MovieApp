package com.giftech.movieapp.data.source

import androidx.lifecycle.LiveData
import com.giftech.movieapp.data.source.local.entity.FilmEntity

interface FilmDataSource {
    fun getAllMovies():LiveData<ArrayList<FilmEntity>>

    fun getMoviesById(id:Int):LiveData<FilmEntity>

    fun getAllTvs():LiveData<ArrayList<FilmEntity>>

    fun getTvById(id:Int):LiveData<FilmEntity>
}