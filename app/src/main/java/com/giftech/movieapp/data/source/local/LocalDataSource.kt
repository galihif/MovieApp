package com.giftech.movieapp.data.source.local

import androidx.lifecycle.LiveData
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao){

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mFilmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mFilmDao)
    }

    fun getAllMovies():LiveData<List<FilmEntity>> = mFilmDao.getAllMovies()
    fun getAllTvs():LiveData<List<FilmEntity>> = mFilmDao.getAllTvs()
    fun getBookmarkedMovies():LiveData<List<FilmEntity>> = mFilmDao.getBookmarkedMovies()
    fun getBookmarkedTvs():LiveData<List<FilmEntity>> = mFilmDao.getBookmarkedTvs()
    fun getMovieById(id:String):LiveData<FilmEntity> = mFilmDao.getMovieById(id)
    fun getTvById(id:String):LiveData<FilmEntity> = mFilmDao.getTvById(id)
    fun insertFilms(listFilms:List<FilmEntity>) = mFilmDao.insertFilms(listFilms)
    fun updateFilm(film:FilmEntity) = mFilmDao.updateFilm(film)

}