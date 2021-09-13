package com.giftech.movieapp.utils

import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.response.TvResultsItem

object TvShowDummy {

    fun generateDummyTvShows():List<FilmEntity>{
        val tvshows = ArrayList<FilmEntity>()

        tvshows.add(
            FilmEntity(
                1,
                "WandaVision",
                "Superhero, Action",
                "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
                "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg",
                false,
                false
            )
        )

        return tvshows
    }

    fun generateRemoteDummyTvShows():List<TvResultsItem>{
        val tvshows = ArrayList<TvResultsItem>()

        tvshows.add(
            TvResultsItem(
                id = 1,
                name = "WandaVision",
                genreIds = ArrayList<Int>(),
                overview = "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
                posterPath = "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg"
            )
        )

        return tvshows
    }

    fun generateDummyDetailTv(): FilmEntity {
        return  FilmEntity(
            1,
            "WandaVision",
            "Superhero, Action",
            "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
            "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg",
            false,
            false
        )
    }

}