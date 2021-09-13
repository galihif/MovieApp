package com.giftech.movieapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import com.giftech.movieapp.vo.Resource
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
    private val dummyMovie = Resource.success(MovieDummy.generateDummyMovies()[0])
    private val dummyTv = Resource.success(TvShowDummy.generateDummyTvShows()[0])

    private val movieId = dummyMovie.data?.id
    private val tvId = dummyTv.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var filmObserver:Observer<Resource<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(filmRepository)
    }

    @Test
    fun getMovieById() {
        val movie = MutableLiveData<Resource<FilmEntity>>()
        movie.value = dummyMovie

        `when`(filmRepository.getMoviesById(movieId!!)).thenReturn(movie)
        val movieEntity = viewModel.getMovieById(movieId).value

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.data?.id, movieEntity?.data?.id)
        assertEquals(dummyMovie.data?.title, movieEntity?.data?.title)
        assertEquals(dummyMovie.data?.genre, movieEntity?.data?.genre)
        assertEquals(dummyMovie.data?.sinopsis, movieEntity?.data?.sinopsis)
        assertEquals(dummyMovie.data?.poster, movieEntity?.data?.poster)

        viewModel.getMovieById(movieId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvById() {
        val tv = MutableLiveData<Resource<FilmEntity>>()
        tv.value = dummyTv

        `when`(filmRepository.getTvById(tvId!!)).thenReturn(tv)
        val tvEntity = viewModel.getTvById(tvId).value

        assertNotNull(tvEntity)
        assertEquals(dummyTv.data?.id, tvEntity?.data?.id)
        assertEquals(dummyTv.data?.title, tvEntity?.data?.title)
        assertEquals(dummyTv.data?.genre, tvEntity?.data?.genre)
        assertEquals(dummyTv.data?.sinopsis, tvEntity?.data?.sinopsis)
        assertEquals(dummyTv.data?.poster, tvEntity?.data?.poster)

        viewModel.getTvById(tvId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyTv)
    }
}