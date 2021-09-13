package com.giftech.movieapp.ui.bookmarkmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity

class BookmarkMoviesViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getBookmarkedMovies():LiveData<List<FilmEntity>> = filmRepository.getBookmarkedMovies()

}