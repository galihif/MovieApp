package com.giftech.movieapp.ui.bookmarktvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity

class BookmarkTvshowViewmodel(private val filmRepository: FilmRepository): ViewModel() {

    fun getBookmarkedTvshow():LiveData<List<FilmEntity>> = filmRepository.getBookmarkedTvs()

}