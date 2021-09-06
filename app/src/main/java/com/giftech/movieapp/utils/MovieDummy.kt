package com.giftech.movieapp.utils

import com.giftech.movieapp.data.FilmEntity

object MovieDummy {

    fun generateDummyMovies():ArrayList<FilmEntity>{
        val movies = ArrayList<FilmEntity>()

        movies.add(
            FilmEntity(
                "Iron Man",
                "Superhero, Action",
                "When Tony Stark, an industrialist," +
                        " is captured, he constructs a high-tech armoured suit to escape. " +
                        "Once he manages to escape, he decides to use his suit to fight " +
                        "against evil forces to save the world.",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )
        movies.add(
            FilmEntity(
                "The Incredible Hulk",
                "Superhero, Action",
                "Dr Bruce Banner subjects himself to high levels of gamma radiation which triggers his transformation into a huge green creature, the Hulk, whenever he experiences negative emotions such as anger.",
                "http://www.movienewsletters.net/photos/277217R1.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Iron Man 2",
                "Superhero, Action",
                "With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father's legacy.",
                "https://m.media-amazon.com/images/M/MV5BMTM0MDgwNjMyMl5BMl5BanBnXkFtZTcwNTg3NzAzMw@@._V1_FMjpg_UX1000_.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Thor",
                "Superhero, Action",
                "Thor is exiled by his father, Odin, the King of Asgard, to the Earth to live among mortals. When he lands on Earth, his trusted weapon Mjolnir is discovered and captured by S.H.I.E.L.D.",
                "https://upload.wikimedia.org/wikipedia/en/9/95/Thor_%28film%29_poster.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Captain America: The First Avenger",
                "Superhero, Action",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                "https://upload.wikimedia.org/wikipedia/id/3/37/Captain_America_The_First_Avenger_poster.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "The Avengers",
                "Superhero, Action",
                "Nick Fury is compelled to launch the Avengers Initiative when Loki poses a threat to planet Earth. His squad of superheroes put their minds together to accomplish the task.",
                "https://upload.wikimedia.org/wikipedia/id/f/f9/TheAvengers2012Poster.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Iron Man 3",
                "Superhero, Action",
                "Tony Stark encounters a formidable foe called the Mandarin. After failing to defeat his enemy, Tony embarks on a journey of self-discovery as he fights against the powerful Mandarin.",
                "https://upload.wikimedia.org/wikipedia/id/d/d5/Iron_Man_3_theatrical_poster.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Thor: The Dark World",
                "Superhero, Action",
                "Thor sets out on a journey to defeat Malekith, the leader of the Dark Elves when he returns to Asgard to retrieve a dangerous weapon and fulfill his desire of destroying the Nine Realms.",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t"
            )
        )
        movies.add(
            FilmEntity(
                "Captain America: The Winter Soldier",
                "Superhero, Action",
                "As Steve Rogers adapts to the complexities of a contemporary world, he joins Natasha Romanoff and Sam Wilson in his mission to uncover the secret behind a deadly, mysterious assassin.",
                "https://m.media-amazon.com/images/M/MV5BMzA2NDkwODAwM15BMl5BanBnXkFtZTgwODk5MTgzMTE@._V1_FMjpg_UX1000_.jpg"
            )
        )
        movies.add(
            FilmEntity(
                "Guardians of the Galaxy",
                "Superhero, Action",
                "Peter escapes from the planet Morag with a valuable orb that Ronan the Accuser wants. He eventually forms a group with unwilling heroes to stop Ronan.",
                "https://upload.wikimedia.org/wikipedia/en/3/33/Guardians_of_the_Galaxy_%28film%29_poster.jpg"
            )
        )


        return movies
    }

}