package com.giftech.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.giftech.movieapp.data.source.FilmRepository
import com.giftech.movieapp.di.Injection
import com.giftech.movieapp.ui.detail.DetailViewModel
import com.giftech.movieapp.ui.movies.MoviesViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository)
    :ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java)->{
                return MoviesViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java)->{
                return DetailViewModel(mFilmRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}