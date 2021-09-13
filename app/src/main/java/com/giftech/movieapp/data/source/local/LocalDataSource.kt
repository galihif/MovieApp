package com.giftech.movieapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao){

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mFilmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mFilmDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getAllMovies()
    fun getAllTvs(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getAllTvs()
    fun getBookmarkedMovies():LiveData<List<FilmEntity>> = mFilmDao.getBookmarkedMovies()
    fun getBookmarkedTvs():LiveData<List<FilmEntity>> = mFilmDao.getBookmarkedTvs()
    fun getMovieById(id:Int):LiveData<FilmEntity> = mFilmDao.getMovieById(id)
    fun getTvById(id:Int):LiveData<FilmEntity> = mFilmDao.getTvById(id)
    fun insertListFilms(listFilms:List<FilmEntity>) = mFilmDao.insertListFilms(listFilms)
    fun insertFilm(film:FilmEntity) = mFilmDao.insertFilm(film)
    fun updateFilm(film:FilmEntity) = mFilmDao.updateFilm(film)
    fun setBookmarkFilm(film:FilmEntity) =  mFilmDao.updateFilm(film)

}