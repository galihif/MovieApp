package com.giftech.movieapp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.data.source.FilmRepository

class TvShowViewModel(private val filmRepository: FilmRepository):ViewModel() {

//    fun getTvShow():ArrayList<FilmEntity> = TvShowDummy.generateDummyTvShows()

    fun getTvShow():LiveData<ArrayList<FilmEntity>> = filmRepository.getAllTvs()
}