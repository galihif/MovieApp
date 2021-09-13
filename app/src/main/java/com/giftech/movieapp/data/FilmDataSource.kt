package com.giftech.movieapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.vo.Resource

interface FilmDataSource {
    fun getAllMovies():LiveData<Resource<PagedList<FilmEntity>>>

    fun getMoviesById(id:Int):LiveData<Resource<FilmEntity>>

    fun getAllTvs():LiveData<Resource<PagedList<FilmEntity>>>

    fun getTvById(id:Int):LiveData<Resource<FilmEntity>>

    fun getBookmarkedMovies():LiveData<List<FilmEntity>>

    fun getBookmarkedTvs():LiveData<List<FilmEntity>>

    fun setBookmarkedFilm(filmEntity: FilmEntity)
}