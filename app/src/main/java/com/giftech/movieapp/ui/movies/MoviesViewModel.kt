package com.giftech.movieapp.ui.movies

import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.utils.MovieDummy

class MoviesViewModel:ViewModel() {

    fun getMovies():ArrayList<FilmEntity> = MovieDummy.generateDummyMovies()

}