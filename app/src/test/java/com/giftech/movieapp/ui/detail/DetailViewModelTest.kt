package com.giftech.movieapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.data.source.FilmRepository
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = MovieDummy.generateDummyMovies()[0]
    private val dummyTv = TvShowDummy.generateDummyTvShows()[0]

    private val movieId = dummyMovie.id
    private val tvId = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var filmObserver:Observer<FilmEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(filmRepository)
    }

    @Test
    fun getMovieById() {
        val movie = MutableLiveData<FilmEntity>()
        movie.value = dummyMovie

        `when`(filmRepository.getMoviesById(movieId!!)).thenReturn(movie)
        val movieEntity = viewModel.getMovieById(movieId).value as FilmEntity

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.sinopsis, movieEntity.sinopsis)
        assertEquals(dummyMovie.poster, movieEntity.poster)

        viewModel.getMovieById(movieId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvById() {
        val tv = MutableLiveData<FilmEntity>()
        tv.value = dummyTv

        `when`(filmRepository.getTvById(tvId!!)).thenReturn(tv)
        val tvEntity = viewModel.getTvById(tvId).value as FilmEntity

        assertNotNull(tvEntity)
        assertEquals(dummyTv.id, tvEntity.id)
        assertEquals(dummyTv.title, tvEntity.title)
        assertEquals(dummyTv.genre, tvEntity.genre)
        assertEquals(dummyTv.sinopsis, tvEntity.sinopsis)
        assertEquals(dummyTv.poster, tvEntity.poster)

        viewModel.getTvById(tvId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyTv)
    }
}