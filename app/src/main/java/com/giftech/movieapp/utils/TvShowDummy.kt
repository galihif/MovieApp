package com.giftech.movieapp.utils

import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.data.source.remote.response.DetailTvResponse
import com.giftech.movieapp.data.source.remote.response.TvGenresItem
import com.giftech.movieapp.data.source.remote.response.TvResultsItem

object TvShowDummy {

    fun generateDummyTvShows():ArrayList<FilmEntity>{
        val tvshows = ArrayList<FilmEntity>()

        tvshows.add(
            FilmEntity(
                1,
                "WandaVision",
                "Superhero, Action",
                "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
                "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                2,
                "The Falcon and The Winter Soldier",
                "Superhero, Action",
                "Falcon and the Winter Soldier are a mismatched duo who team up for a global adventure that will test their survival skills -- as well as their patience.",
                "https://berlinbearsnewsonline.com/wp-content/uploads/2021/03/tag_teaser_digital_keyart_v5_lg-608x900.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                3,
                "Loki",
                "Superhero, Action",
                "Loki, the God of Mischief, steps out of his brother's shadow to embark on an adventure that takes place after the events of \"Avengers: Endgame.\"",
                "https://cdn06.pramborsfm.com/storage/app/media/Prambors/Editorial/serial-loki-1-20210608080222.jpg?tr=w-800"
            )
        )
        tvshows.add(
            FilmEntity(
                4,
                "What If...?",
                "Superhero, Action",
                "Reimagining noteworthy events in the Marvel Cinematic Universe and creating a multiverse of infinite possibilities.",
                "https://media.comicbook.com/2021/07/marvel-what-if-tv-series-poster-official-disney-plus-1274908.jpeg?auto=webp&width=1280&height=1897&crop=1280:1897,smart"
            )
        )
        tvshows.add(
            FilmEntity(
                5,
                "Captain America: The First Avenger",
                "Superhero, Action",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                "https://upload.wikimedia.org/wikipedia/id/3/37/Captain_America_The_First_Avenger_poster.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                6,
                "Start-Up",
                "Superhero, Action",
                "Seo Dal Mi has dreams of becoming Korea's own Steve Jobs, and with her genius first love, an investor, and a business insider by her side, her dream may be closer than she thinks.",
                "https://upload.wikimedia.org/wikipedia/en/1/12/Start-Up_2020.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                7,
                "Crash Landing on You",
                "Superhero, Action",
                "A paragliding mishap drops a South Korean heiress in North Korea - and into the life of an army officer, who decides he will help her hide.",
                "https://asianwiki.com/images/f/f8/Crash_Landing_on_You-P1.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                8,
                "It's Okay to Not Be Okay",
                "Superhero, Action",
                "A road to emotional healing opens up for an antisocial children's book author and an employee in a psychiatric hospital.",
                "https://i.mydramalist.com/xw3xX_4f.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                9,
                "Monsters at Work",
                "Superhero, Action",
                "Mechanic Tylor Tuskmon has big dreams of working his way up the ranks to the Laugh Floor at Monsters Inc.",
                "https://www.themoviedb.org/t/p/original/2gxgwhcuSmI5xtexb0t9zGj43FS.jpg"
            )
        )
        tvshows.add(
            FilmEntity(
                10,
                "SpongeBob SquarePants",
                "Superhero, Action",
                "A yellow sea sponge named SpongeBob SquarePants, who enjoys being a cook at Krusty Krab, lives in the Pacific Ocean. He embarks on various adventures with his friends at Bikini Bottom.",
                "https://picfiles.alphacoders.com/108/108129.jpg"
            )
        )


        return tvshows
    }

    fun generateRemoteDummyTvShows():ArrayList<TvResultsItem>{
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
        tvshows.add(
            TvResultsItem(
                id = 1,
                name = "WandaVision",
                genreIds = ArrayList<Int>(),
                overview = "Living idealized suburban lives, super-powered beings Wanda and Vision begin to suspect that everything is not as it seems.",
                posterPath = "https://m.media-amazon.com/images/M/MV5BZGEwYmMwZmMtMTQ3MS00YWNhLWEwMmQtZTU5YTIwZmJjZGQ0XkEyXkFqcGdeQXVyMTI5MzA5MjA1._V1_.jpg"
            )
        )
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