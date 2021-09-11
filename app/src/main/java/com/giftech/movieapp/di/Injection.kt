package com.giftech.movieapp.di

import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): FilmRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return FilmRepository.getInstance(remoteDataSource)
    }
}