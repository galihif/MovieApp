package com.giftech.movieapp.ui.detail

import com.giftech.movieapp.data.FilmEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovieById() {
        val movie = FilmEntity(
            1,
            "Iron Man",
            "Superhero, Action",
            "When Tony Stark, an industrialist," +
                    " is captured, he constructs a high-tech armoured suit to escape. " +
                    "Once he manages to escape, he decides to use his suit to fight " +
                    "against evil forces to save the world.",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
        )
        val mMovie = viewModel.getMovieById(1)
        assertNotNull(mMovie)
        assertEquals(movie,mMovie)
    }

    @Test
    fun getTvById() {
        val tvShow = FilmEntity(
            1,
            "WandaVision",
            "Superhero, Action",
            "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
            "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg"
        )
        val mTvShow = viewModel.getTvById(1)
        assertNotNull(mTvShow)
        assertEquals(tvShow,mTvShow)
    }
}