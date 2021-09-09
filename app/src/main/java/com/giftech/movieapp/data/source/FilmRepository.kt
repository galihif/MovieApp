package com.giftech.movieapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.data.source.remote.ResultsItem
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource)
    :FilmDataSource{

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(remoteData: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData).apply { instance = this }
            }
    }


    override fun getAllMovies(): LiveData<ArrayList<FilmEntity>> {
        val movieResults = MutableLiveData<ArrayList<FilmEntity>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onResultsResponseReceived(results: List<ResultsItem>) {
                val movieList = ArrayList<FilmEntity>()

                for(movieRes in results){
                    val movie = FilmEntity()
                    movie.id = movieRes.id
                    movie.title = movieRes.title
                    movie.genre = movieRes.genreIds.toString()
                    movie.sinopsis = movieRes.overview
                    movie.poster = movieRes.posterPath

                    movieList.add(movie)
                }

                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getMoviesById(id: Int): LiveData<FilmEntity> {
        val movie = MutableLiveData<FilmEntity>()

        remoteDataSource.getMovieById(id, object : RemoteDataSource.LoadMoviesByIdCallback{
            override fun onResultsResponseReceived(results: DetailMovieResponse) {
                val movieRes = FilmEntity()
                movieRes.id = results.id
                movieRes.title = results.title
                movieRes.genre = results.genres.toString()
                movieRes.sinopsis = results.overview
                movieRes.poster = results.posterPath

                movie.postValue(movieRes)
            }
        })

        return movie
    }
}