package com.giftech.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import com.giftech.movieapp.vo.Resource

class DetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private val listMovies = MovieDummy.generateDummyMovies()
    private val listTvShow = TvShowDummy.generateDummyTvShows()


    fun getMovieById(movieId:Int):LiveData<Resource<FilmEntity>> = filmRepository.getMoviesById(movieId)

    fun getTvById(movieId:Int):LiveData<Resource<FilmEntity>> = filmRepository.getTvById(movieId)
}
