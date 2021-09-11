package com.giftech.movieapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.FilmRepository


class MoviesViewModel(private val filmRepository: FilmRepository):ViewModel() {


    fun getMovies():LiveData<ArrayList<FilmEntity>> = filmRepository.getAllMovies()

}