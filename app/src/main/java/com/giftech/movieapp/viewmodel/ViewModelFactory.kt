package com.giftech.movieapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.di.Injection
import com.giftech.movieapp.ui.bookmarkmovies.BookmarkMoviesViewModel
import com.giftech.movieapp.ui.bookmarktvshow.BookmarkTvshowViewmodel
import com.giftech.movieapp.ui.detail.DetailViewModel
import com.giftech.movieapp.ui.movies.MoviesViewModel
import com.giftech.movieapp.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository)
    :ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
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
            modelClass.isAssignableFrom(TvShowViewModel::class.java)->{
                return TvShowViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkMoviesViewModel::class.java)->{
                return BookmarkMoviesViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkTvshowViewmodel::class.java)->{
                return BookmarkTvshowViewmodel(mFilmRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}