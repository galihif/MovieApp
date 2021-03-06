package com.giftech.movieapp.data.source.remote.api

import com.giftech.movieapp.data.source.remote.MovieResponse
import com.giftech.movieapp.data.source.remote.api.ApiConfig.Companion.API_KEY
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/3/movie/popular?api_key=$API_KEY&page=1")
    fun getMovies(): retrofit2.Call<MovieResponse>

    @GET("/3/movie/{id}?api_key=$API_KEY")
    fun getMoviesById(@Path("id") id:Int):retrofit2.Call<DetailMovieResponse>

    @GET("/3/tv/popular?api_key=$API_KEY")
    fun getTvs(): retrofit2.Call<TvResponse>

    @GET("/3/tv/{id}?api_key=$API_KEY")
    fun getTvById(@Path("id") id:Int):retrofit2.Call<DetailTvResponse>

}