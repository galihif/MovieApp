package com.giftech.movieapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.MovieResultsItem
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvResultsItem

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource)
    : FilmDataSource {

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
                    val movie = FilmEntity(
                        id=movieRes.id,
                        title = movieRes.title,
                        genre = movieRes.genreIds.toString(),
                        sinopsis = movieRes.overview,
                        poster = "https://image.tmdb.org/t/p/w500/${movieRes.posterPath}",
                        bookmarked = 0,
                        type = 1
                    )
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

                val genre = StringBuilder()
                for (gen in results.genres!!){
                    val genName = gen?.name
                    genre.append("$genName ")
                }

                val movieRes = FilmEntity(
                    id=results.id,
                    title = results.title,
                    genre = genre.toString(),
                    sinopsis = results.overview,
                    poster = "https://image.tmdb.org/t/p/w500/${results.posterPath}",
                    bookmarked = 0,
                    type = 1
                )

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
                    val tvRes = FilmEntity(
                        id = res.id,
                        title = res.name,
                        genre = res.genreIds.toString(),
                        sinopsis = res.overview,
                        poster = "https://image.tmdb.org/t/p/w500/${res.posterPath}",
                        bookmarked = 0,
                        type = 1
                    )
                    listTvRes.add(tvRes)
                }

                listTv.postValue(listTvRes)
            }

        })

        return listTv
    }

    override fun getTvById(id: Int): LiveData<FilmEntity> {
        val tv = MutableLiveData<FilmEntity>()

        remoteDataSource.getTvById(id, object : RemoteDataSource.LoadTvByIdCallback{
            override fun onResultsResponseReceived(results: DetailTvResponse) {
                val genre = StringBuilder()
                for (gen in results.genres!!){
                    val genName = gen?.name
                    genre.append("$genName ")
                }
                val tvRes = FilmEntity(
                    id = results.id,
                    title = results.name,
                    genre = genre.toString(),
                    sinopsis = results.overview,
                    poster = "https://image.tmdb.org/t/p/w500/${results.posterPath}",
                    bookmarked = 0,
                    type = 1
                )
                tv.postValue(tvRes)
            }
        })

        return tv
    }
}