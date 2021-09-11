package com.giftech.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.FilmRepository
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy

class DetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private val listMovies = MovieDummy.generateDummyMovies()
    private val listTvShow = TvShowDummy.generateDummyTvShows()

//    fun getMovieById(movieId:Int): FilmEntity {
//        lateinit var mMovie:FilmEntity
//        for (movie in listMovies){
//            if (movie.id == movieId){
//                mMovie = movie
//            }
//        }
//        return mMovie
//    }

    fun getMovieById(movieId:Int):LiveData<FilmEntity> = filmRepository.getMoviesById(movieId)

    fun getTvById(movieId:Int):LiveData<FilmEntity> = filmRepository.getTvById(movieId)

//    fun getTvById(tvId:Int):FilmEntity {
//        lateinit var mTvShow:FilmEntity
//        for (tvShow in listTvShow){
//            if(tvShow.id == tvId){
//                mTvShow = tvShow
//            }
//        }
//        return mTvShow
//    }
}