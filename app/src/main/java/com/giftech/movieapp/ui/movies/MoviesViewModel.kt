package com.giftech.movieapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.vo.Resource


class MoviesViewModel(private val filmRepository: FilmRepository):ViewModel() {


    fun getMovies():LiveData<Resource<List<FilmEntity>>> = filmRepository.getAllMovies()

}