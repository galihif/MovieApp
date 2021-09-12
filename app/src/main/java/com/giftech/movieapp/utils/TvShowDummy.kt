package com.giftech.movieapp.utils

import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvGenresItem

object TvShowDummy {

    fun generateDummyTvShows():ArrayList<FilmEntity>{
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

    fun generateRemoteDummyDetailTv(): DetailTvResponse {
        return DetailTvResponse(
            id=1,
            name="WandaVision",
            genres = ArrayList<TvGenresItem>(),
            overview = "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
            posterPath = "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg"
        )
    }

}