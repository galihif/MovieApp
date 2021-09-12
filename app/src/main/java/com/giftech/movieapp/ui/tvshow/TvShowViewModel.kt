package com.giftech.movieapp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository):ViewModel() {

//    fun getTvShow():ArrayList<FilmEntity> = TvShowDummy.generateDummyTvShows()

    fun getTvShow():LiveData<Resource<List<FilmEntity>>> = filmRepository.getAllTvs()
}