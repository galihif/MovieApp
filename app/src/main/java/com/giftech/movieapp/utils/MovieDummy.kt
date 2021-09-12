package com.giftech.movieapp.utils

import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.data.source.remote.MovieResultsItem
import com.giftech.movieapp.data.source.remote.response.DetailMovieResponse
import com.giftech.movieapp.data.source.remote.response.GenresItem

object MovieDummy {

    fun generateDummyMovies():ArrayList<FilmEntity>{
        val movies = ArrayList<FilmEntity>()

        movies.add(
            FilmEntity(
                1,
                "Iron Man",
                "Superhero, Action",
                "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t",
                false,
                true
            )
        )


        return movies
    }

    fun generateRemoteDummyMovies():ArrayList<MovieResultsItem>{
        val movies = ArrayList<MovieResultsItem>()

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )

        movies.add(
            MovieResultsItem(
                id=1,
                title="Iron Man",
                genreIds = ArrayList<Int>(),
                overview = "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )


        return movies
    }

    fun generateRemoteDummyDetailMovie():DetailMovieResponse{
        return DetailMovieResponse(
            id=1,
            title="Iron Man",
            genres = ArrayList<GenresItem>(),
            overview = "When Tony Stark, an industrialist," +
                    " is captured, he constructs a high-tech armoured suit to escape. " +
                    "Once he manages to escape, he decides to use his suit to fight " +
                    "against evil forces to save the world.",
            posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
        )
    }
}