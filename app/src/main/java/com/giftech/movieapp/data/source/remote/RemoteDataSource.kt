package com.giftech.movieapp.data.source.remote

import android.util.Log
import com.giftech.movieapp.data.source.remote.api.ApiConfig
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import retrofit2.Call
import retrofit2.Response

class RemoteDataSource {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getAllMovies(callback:LoadMoviesCallback){
        val client = ApiConfig.getApiService().getMovies()
        client.enqueue(object : retrofit2.Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    val listResultsItem = response.body()?.results
                    callback.onResultsResponseReceived(listResultsItem as List<ResultsItem>)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getMovieById(id:Int, callback:LoadMoviesByIdCallback){
        val client = ApiConfig.getApiService().getMoviesById(id)
        client.enqueue(object : retrofit2.Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if(response.isSuccessful){
                    val res = response.body()
                    callback.onResultsResponseReceived(res!!)
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    interface LoadMoviesCallback {
        fun onResultsResponseReceived(results: List<ResultsItem>)
    }

    interface LoadMoviesByIdCallback {
        fun onResultsResponseReceived(results: DetailMovieResponse)
    }

}