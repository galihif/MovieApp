package com.giftech.movieapp.ui.bookmarktvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.giftech.movieapp.data.FilmRepository
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.utils.TvShowDummy
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
class BookmarkTvshowViewmodelTest {

    private lateinit var viewModel: BookmarkTvshowViewmodel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp(){
        viewModel = BookmarkTvshowViewmodel(filmRepository)
    }

    @Test
    fun getBookmarkedTvshow() {
        val dummyTvs = TvShowDummy.generateDummyTvShows()

        val tvs = MutableLiveData<List<FilmEntity>>()
        tvs.value = dummyTvs

        Mockito.`when`(filmRepository.getBookmarkedTvs()).thenReturn(tvs)
        val tvsEntities = viewModel.getBookmarkedTvshow().value
        verify(filmRepository).getBookmarkedTvs()
        Assert.assertNotNull(tvsEntities)
        Assert.assertEquals(1, tvsEntities?.size)

        viewModel.getBookmarkedTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvs)
    }
}