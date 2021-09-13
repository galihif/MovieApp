package com.giftech.movieapp.ui.bookmarkmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.utils.MovieDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BookmarkMoviesViewModelTest {

    private lateinit var viewModel: BookmarkMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp(){
        viewModel = BookmarkMoviesViewModel(filmRepository)
    }

    @Test
    fun getBookmarkedMovies() {
        val dummyMovies = MovieDummy.generateDummyMovies()

        val movies = MutableLiveData<List<FilmEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(filmRepository.getBookmarkedMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getBookmarkedMovies().value
        verify(filmRepository).getBookmarkedMovies()
        Assert.assertNotNull(moviesEntities)
        Assert.assertEquals(1, moviesEntities?.size)

        viewModel.getBookmarkedMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}