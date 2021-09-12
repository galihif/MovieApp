package com.giftech.movieapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.giftech.movieapp.data.source.remote.api.ApiConfig
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvResponse
import com.giftech.movieapp.data.source.remote.response.TvResultsItem
import com.giftech.movieapp.utils.EspressoIdlingResource
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

    fun getAllMovies():LiveData<ApiResponse<List<MovieResultsItem>>>{
        EspressoIdlingResource.increment()
        val listMovieRes = MutableLiveData<ApiResponse<List<MovieResultsItem>>>()
        val client = ApiConfig.getApiService().getMovies()
        client.enqueue(object : retrofit2.Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    val listResultsItem = response.body()?.results
                    listMovieRes.value = ApiResponse.success(listResultsItem as List<MovieResultsItem>)
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message.toString()}")
            }

        })
        return listMovieRes
    }

    fun getMovieById(id:Int):LiveData<ApiResponse<DetailMovieResponse>>{
        EspressoIdlingResource.increment()
        val movieRes = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        val client = ApiConfig.getApiService().getMoviesById(id)
        client.enqueue(object : retrofit2.Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if(response.isSuccessful){
                    val res = response.body()
                    movieRes.value = ApiResponse.success(res as DetailMovieResponse)
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message.toString()}")
            }

        })
        return movieRes
    }

    fun getAllTvs():LiveData<ApiResponse<List<TvResultsItem>>>{
        EspressoIdlingResource.increment()
        val listTvRes = MutableLiveData<ApiResponse<List<TvResultsItem>>>()
        val client = ApiConfig.getApiService().getTvs()
        client.enqueue(object : retrofit2.Callback<TvResponse>{
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                if(response.isSuccessful){
                    val tvRes = response.body()?.results
                    listTvRes.value = ApiResponse.success(tvRes as List<TvResultsItem>)
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message.toString()}")
            }

        })
        return listTvRes
    }

    fun getTvById(id:Int):LiveData<ApiResponse<DetailTvResponse>>{
        EspressoIdlingResource.increment()
        val tvRes = MutableLiveData<ApiResponse<DetailTvResponse>>()
        val client = ApiConfig.getApiService().getTvById(id)
        client.enqueue(object :retrofit2.Callback<DetailTvResponse>{
            override fun onResponse(
                call: Call<DetailTvResponse>,
                response: Response<DetailTvResponse>
            ) {
                if(response.isSuccessful){
                    val res = response.body()
                    tvRes.value = ApiResponse.success(res as DetailTvResponse)
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailTvResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message.toString()}")
            }
        })
        return tvRes
    }


    interface LoadMoviesCallback {
        fun onResultsResponseReceived(results: List<MovieResultsItem>)
    }

    interface LoadMoviesByIdCallback {
        fun onResultsResponseReceived(results: DetailMovieResponse)
    }

    interface LoadTvsCallback {
        fun onResultsResponseReceived(results: List<TvResultsItem>)
    }

    interface LoadTvByIdCallback {
        fun onResultsResponseReceived(results: DetailTvResponse)
    }
}