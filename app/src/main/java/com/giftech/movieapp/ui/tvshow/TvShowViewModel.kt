package com.giftech.movieapp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.utils.TvShowDummy

class TvShowViewModel:ViewModel() {

    fun getTvShow():ArrayList<FilmEntity> = TvShowDummy.generateDummyTvShows()

}