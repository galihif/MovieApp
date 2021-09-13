package com.giftech.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.giftech.movieapp.data.source.local.LocalDataSource
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.RemoteDataSource
import com.giftech.movieapp.utils.AppExecutors
import com.giftech.movieapp.utils.LiveDataTestUtil
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val filmRepository = FakeFilmRepository(remote,local,appExecutors)

    private val moviesResponses = MovieDummy.generateDummyMovies()
    private val detailMovieResponse = MovieDummy.generateDummyDetailMovie()

    private val tvsResponses = TvShowDummy.generateDummyTvShows()
    private val detailTvResponse = TvShowDummy.generateDummyDetailTv()

    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<FilmEntity>>()
        dummyMovies.value = MovieDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(local).getAllMovies()

        assertNotNull(movieEntities.data)
        assertEquals(moviesResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesById() {
        val dummyMovieById = MutableLiveData<FilmEntity>()
        dummyMovieById.value = MovieDummy.generateDummyDetailMovie()
        `when`(local.getMovieById(1)).thenReturn(dummyMovieById)

        val detailMovieEntity = LiveDataTestUtil.getValue(filmRepository.getMoviesById(1))
        verify(local).getMovieById(1)

        assertNotNull(detailMovieEntity)
        assertEquals(detailMovieResponse.id?.toLong(), detailMovieEntity.data?.id?.toLong())
    }

    @Test
    fun getAllTvs() {
        val dummyTvs = MutableLiveData<List<FilmEntity>>()
        dummyTvs.value = TvShowDummy.generateDummyTvShows()
        `when`(local.getAllTvs()).thenReturn(dummyTvs)

        val tvsEntities = LiveDataTestUtil.getValue(filmRepository.getAllTvs())
        verify(local).getAllTvs()

        assertNotNull(tvsEntities.data)
        assertEquals(tvsResponses.size.toLong(), tvsEntities.data?.size?.toLong())
    }

    @Test
    fun getTvById() {
        val dummyTvById = MutableLiveData<FilmEntity>()
        dummyTvById.value = TvShowDummy.generateDummyDetailTv()
        `when`(local.getTvById(1)).thenReturn(dummyTvById)

        val detailTvEntity = LiveDataTestUtil.getValue(filmRepository.getTvById(1))
        verify(local).getTvById(1)

        assertNotNull(detailTvEntity.data)
        assertEquals(detailTvResponse.id?.toLong(), detailTvEntity.data?.id?.toLong())
    }

    @Test
    fun getBookmarkedMovies() {
        val dummyMovies = MutableLiveData<List<FilmEntity>>()
        dummyMovies.value = MovieDummy.generateDummyMovies()
        `when`(local.getBookmarkedMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getBookmarkedMovies())
        verify(local).getBookmarkedMovies()

        assertNotNull(movieEntities)
        assertEquals(dummyMovies.value!!.size.toLong(), movieEntities?.size.toLong())
    }

    @Test
    fun getBookmarkedTvs() {
        val dummyTvs = MutableLiveData<List<FilmEntity>>()
        dummyTvs.value = TvShowDummy.generateDummyTvShows()
        `when`(local.getBookmarkedTvs()).thenReturn(dummyTvs)

        val tvsEntities = LiveDataTestUtil.getValue(filmRepository.getBookmarkedTvs())
        verify(local).getBookmarkedTvs()

        assertNotNull(tvsEntities)
        assertEquals(dummyTvs.value!!.size.toLong(), tvsEntities?.size?.toLong())
    }


}