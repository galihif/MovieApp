package com.giftech.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy

class DetailViewModel: ViewModel() {

    private val listMovies = MovieDummy.generateDummyMovies()
    private val listTvShow = TvShowDummy.generateDummyTvShows()

    fun getMovieById(movieId:Int):FilmEntity {
        lateinit var mMovie:FilmEntity
        for (movie in listMovies){
            if (movie.id == movieId){
                mMovie = movie
            }
        }
        return mMovie
    }

    fun getTvById(tvId:Int):FilmEntity {
        lateinit var mTvShow:FilmEntity
        for (tvShow in listTvShow){
            if(tvShow.id == tvId){
                mTvShow = tvShow
            }
        }
        return mTvShow
    }
}