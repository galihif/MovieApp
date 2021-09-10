package com.giftech.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.utils.LiveDataTestUtil
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val moviesResponses = MovieDummy.generateRemoteDummyMovies()
    private val movieId = moviesResponses[0].id
    private val detailMovieResponse = MovieDummy.generateRemoteDummyDetailMovie()

    private val tvsResponses = TvShowDummy.generateRemoteDummyTvShows()
    private val tvId = tvsResponses[0].id
    private val detailTvResponse = TvShowDummy.generateRemoteDummyDetailTv()

    @Test
    fun getAllMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onResultsResponseReceived(moviesResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val moviesEntities = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(remote).getAllMovies(any())

        assertNotNull(moviesEntities)
        assertEquals(moviesResponses.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getMoviesById() {
        doAnswer { mock ->
            (mock.arguments[1] as RemoteDataSource.LoadMoviesByIdCallback)
                .onResultsResponseReceived(detailMovieResponse)
            null
        }.`when`(remote).getMovieById(eq(movieId)!!, any())

        val detailMovieEntity = LiveDataTestUtil.getValue(filmRepository.getMoviesById(movieId!!))
        verify(remote).getMovieById(eq(movieId), any())

        assertNotNull(detailMovieEntity)
        assertEquals(detailMovieResponse.id?.toLong(), detailMovieEntity.id?.toLong())
    }

    @Test
    fun getAllTvs() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTvsCallback)
                .onResultsResponseReceived(tvsResponses)
            null
        }.`when`(remote).getAllTvs(any())
        val tvsEntities = LiveDataTestUtil.getValue(filmRepository.getAllTvs())
        verify(remote).getAllTvs(any())

        assertNotNull(tvsEntities)
        assertEquals(tvsResponses.size.toLong(), tvsEntities.size.toLong())
    }

    @Test
    fun getTvById() {
        doAnswer { mock ->
            (mock.arguments[1] as RemoteDataSource.LoadTvByIdCallback)
                .onResultsResponseReceived(detailTvResponse)
            null
        }.`when`(remote).getTvById(eq(tvId)!!, any())

        val detailTvEntity = LiveDataTestUtil.getValue(filmRepository.getTvById(tvId!!))
        verify(remote).getTvById(eq(tvId), any())

        assertNotNull(detailTvEntity)
        assertEquals(detailTvResponse.id?.toLong(), detailTvEntity.id?.toLong())
    }
}