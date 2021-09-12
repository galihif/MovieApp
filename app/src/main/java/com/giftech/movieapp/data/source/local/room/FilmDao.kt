package com.giftech.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.giftech.movieapp.data.source.local.entity.FilmEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM filmentities WHERE type = 0")
    fun getAllMovies():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE type = 1")
    fun getAllTvs():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE type = 1 AND bookmarked = 1")
    fun getBookmarkedMovies():LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE type = 0 AND bookmarked = 1")
    fun getBookmarkedTvs():LiveData<List<FilmEntity>>

    @Transaction
    @Query("SELECT * FROM filmentities WHERE type = 0 AND id = :id")
    fun getMovieById(id:String):LiveData<FilmEntity>

    @Transaction
    @Query("SELECT * FROM filmentities WHERE type = 1 AND id = :id")
    fun getTvById(id:String):LiveData<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(listFilms:List<FilmEntity>)

    @Update
    fun updateFilm(film:FilmEntity)


}