package com.giftech.movieapp.ui.movies

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val listMovies = viewModel.getMovies()
        assertNotNull(listMovies)
        assertEquals(10, listMovies.size)
    }
}