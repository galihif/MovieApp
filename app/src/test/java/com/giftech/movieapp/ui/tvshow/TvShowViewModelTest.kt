package com.giftech.movieapp.ui.tvshow

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val listTv = viewModel.getTvShow()
        assertNotNull(listTv)
        assertEquals(10,listTv.size)
    }
}