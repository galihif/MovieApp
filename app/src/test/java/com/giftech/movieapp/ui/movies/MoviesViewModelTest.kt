package com.giftech.movieapp.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.utils.MovieDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = MovieDummy.generateDummyMovies()

        val movies = MutableLiveData<ArrayList<FilmEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(filmRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value
        verify(filmRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}