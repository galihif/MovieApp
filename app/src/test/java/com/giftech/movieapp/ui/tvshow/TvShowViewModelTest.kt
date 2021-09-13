package com.giftech.movieapp.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.vo.Resource
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<FilmEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
//        val dummyTvs = Resource.success(TvShowDummy.generateDummyTvShows())
        val dummyTvs = Resource.success(pagedList)
        Mockito.`when`(dummyTvs.data?.size).thenReturn(1)

        val tvs = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        tvs.value = dummyTvs

        Mockito.`when`(filmRepository.getAllTvs()).thenReturn(tvs)
        val tvsEntities = viewModel.getTvShow().value
        verify(filmRepository).getAllTvs()

        assertNotNull(tvsEntities)
        assertEquals(1, tvsEntities?.data?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvs)
    }
}