package com.giftech.movieapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.data.source.remote.MovieResultsItem
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.TvResultsItem

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
            override fun onResultsResponseReceived(results: List<MovieResultsItem>) {
                val movieList = ArrayList<FilmEntity>()

                for(movieRes in results){
                    val movie = FilmEntity()
                    movie.id = movieRes.id
                    movie.title = movieRes.title
                    movie.genre = movieRes.genreIds.toString()
                    movie.sinopsis = movieRes.overview
                    val posterUrl = "https://image.tmdb.org/t/p/w500/${movieRes.posterPath}"
                    movie.poster = posterUrl

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
                val posterUrl = "https://image.tmdb.org/t/p/w500/${results.posterPath}"
                movieRes.poster = posterUrl

                movie.postValue(movieRes)
            }
        })

        return movie
    }

    override fun getAllTvs(): LiveData<ArrayList<FilmEntity>> {
        val listTv = MutableLiveData<ArrayList<FilmEntity>>()

        remoteDataSource.getAllTvs(object : RemoteDataSource.LoadTvsCallback{
            override fun onResultsResponseReceived(results: List<TvResultsItem>) {
                val listTvRes = ArrayList<FilmEntity>()

                for (res in results){
                    val tvRes = FilmEntity()
                    tvRes.id = res.id
                    tvRes.title = res.name
                    tvRes.genre = res.genreIds.toString()
                    tvRes.sinopsis = res.overview
                    val posterUrl = "https://image.tmdb.org/t/p/w500/${res.posterPath}"
                    tvRes.poster = posterUrl
                    listTvRes.add(tvRes)
                }

                listTv.postValue(listTvRes)
            }

        })

        return listTv
    }

    override fun getTvById(id: Int): LiveData<FilmEntity> {
        val tv = MutableLiveData<FilmEntity>()

        return tv
    }
}