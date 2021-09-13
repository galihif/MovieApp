package com.giftech.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.giftech.movieapp.data.source.local.entity.FilmEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM filmentities WHERE isMovie = 1")
    fun getAllMovies():DataSource.Factory<Int,FilmEntity>
//    fun getAllMovies():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE isMovie = 0")
    fun getAllTvs():DataSource.Factory<Int,FilmEntity>
//    fun getAllTvs():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE isMovie = 1 AND bookmarked = 1")
    fun getBookmarkedMovies():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE isMovie = 0 AND bookmarked = 1")
    fun getBookmarkedTvs():LiveData<List<FilmEntity>>

    @Transaction
    @Query("SELECT * FROM filmentities WHERE isMovie = 1 AND id = :id")
    fun getMovieById(id:Int):LiveData<FilmEntity>

    @Transaction
    @Query("SELECT * FROM filmentities WHERE isMovie = 0 AND id = :id")
    fun getTvById(id:Int):LiveData<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListFilms(listFilms:List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film:FilmEntity)

    @Update
    fun updateFilm(film:FilmEntity)


}