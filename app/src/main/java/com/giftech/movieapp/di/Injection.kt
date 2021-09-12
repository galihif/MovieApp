package com.giftech.movieapp.di

import android.content.Context
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.LocalDataSource
import com.giftech.movieapp.data.source.local.room.FilmDatabase
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}