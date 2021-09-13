package com.giftech.movieapp.data.source

import androidx.lifecycle.LiveData
import com.giftech.movieapp.data.FilmDataSource
import com.giftech.movieapp.data.NetworkBoundResource
import com.giftech.movieapp.data.source.local.LocalDataSource
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.ApiResponse
import com.giftech.movieapp.data.source.remote.MovieResultsItem
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvResultsItem
import com.giftech.movieapp.utils.AppExecutors
import com.giftech.movieapp.vo.Resource

class FakeFilmRepository(private val remoteDataSource: RemoteDataSource,
                         private val localDataSource: LocalDataSource,
                         private val appExecutors: AppExecutors)
    : FilmDataSource {

    override fun getAllMovies(): LiveData<Resource<List<FilmEntity>>> {

        return object: NetworkBoundResource<List<FilmEntity>, List<MovieResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<List<FilmEntity>> {
                return localDataSource.getAllMovies()
            }

            override fun shouldFetch(data: List<FilmEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<MovieResultsItem>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<MovieResultsItem>) {
                val listMovies = ArrayList<FilmEntity>()
                for (res in data){
                    val movie = FilmEntity(
                        res.id,
                        res.title,
                        res.genreIds.toString(),
                        res.overview,
                        "https://image.tmdb.org/t/p/w500/${res.posterPath}",
                        false,
                        true
                    )
                    listMovies.add(movie)
                }
                localDataSource.insertListFilms(listMovies)
            }

        }.asLiveData()
    }

    override fun getMoviesById(id: Int): LiveData<Resource<FilmEntity>> {

        return object : NetworkBoundResource<FilmEntity,DetailMovieResponse>(appExecutors){
            override fun loadFromDB(): LiveData<FilmEntity> {
                return localDataSource.getMovieById(id)
            }

            override fun shouldFetch(data: FilmEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> {
                return remoteDataSource.getMovieById(id)
            }

            override fun saveCallResult(data: DetailMovieResponse) {
                val genre = StringBuilder()
                for (gen in data.genres!!){
                    val genName = gen?.name
                    genre.append("$genName ")
                }
                val movie = FilmEntity(
                    data.id,
                    data.title,
                    genre.toString(),
                    data.overview,
                    "https://image.tmdb.org/t/p/w500/${data.posterPath}",
                    false,
                    true
                )
                localDataSource.insertFilm(movie)
            }

        }.asLiveData()
    }

    override fun getAllTvs(): LiveData<Resource<List<FilmEntity>>> {
        return object : NetworkBoundResource<List<FilmEntity>, List<TvResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<List<FilmEntity>> {
                return localDataSource.getAllTvs()
            }

            override fun shouldFetch(data: List<FilmEntity>?): Boolean {
                return data==null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvResultsItem>>> {
                return remoteDataSource.getAllTvs()
            }

            override fun saveCallResult(data: List<TvResultsItem>) {
                val listTv = ArrayList<FilmEntity>()
                for (res in data){
                    listTv.add(
                        FilmEntity(
                            res.id,
                            res.name,
                            res.genreIds.toString(),
                            res.overview,
                            "https://image.tmdb.org/t/p/w500/${res.posterPath}",
                            false,
                            false
                        )
                    )
                }
                localDataSource.insertListFilms(listTv)
            }

        }.asLiveData()
    }

    override fun getTvById(id: Int): LiveData<Resource<FilmEntity>> {
        return object : NetworkBoundResource<FilmEntity,DetailTvResponse>(appExecutors){
            override fun loadFromDB(): LiveData<FilmEntity> {
                return localDataSource.getTvById(id)
            }

            override fun shouldFetch(data: FilmEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<DetailTvResponse>> {
                return remoteDataSource.getTvById(id)
            }

            override fun saveCallResult(data: DetailTvResponse) {
                val genre = StringBuilder()
                for (gen in data.genres!!){
                    val genName = gen?.name
                    genre.append("$genName ")
                }
                val tv = FilmEntity(
                    data.id,
                    data.name,
                    genre.toString(),
                    data.overview,
                    "https://image.tmdb.org/t/p/w500/${data.posterPath}",
                    false,
                    false
                )
                localDataSource.insertFilm(tv)
            }

        }.asLiveData()
    }

    override fun getBookmarkedMovies(): LiveData<List<FilmEntity>> {
        return localDataSource.getBookmarkedMovies()
    }

    override fun getBookmarkedTvs(): LiveData<List<FilmEntity>> {
        return localDataSource.getBookmarkedTvs()
    }

    override fun setBookmarkedFilm(filmEntity: FilmEntity) {
        appExecutors.diskIO().execute {
            localDataSource.setBookmarkFilm(filmEntity)
        }
    }
}