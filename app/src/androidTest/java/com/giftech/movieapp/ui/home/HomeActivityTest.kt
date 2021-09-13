package com.giftech.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.giftech.movieapp.R
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.utils.EspressoIdlingResource
import com.giftech.movieapp.utils.MovieDummy
import com.giftech.movieapp.utils.TvShowDummy
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{

    private val dummyMovies = MovieDummy.generateDummyMovies()
    private val dummyDetailMove = FilmEntity(
        379686,
        "Space Jam: A New Legacy",
        "Superhero, Action",
        "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
        "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t",
        false,
        true
    )
    private val dummyTv = TvShowDummy.generateDummyTvShows()
    private val dummyDetailTv = FilmEntity(
        1399,
        "Game of Thrones",
        "Superhero, Action",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
        "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSMoliPRgy5xgoyg_eZmuKyptS9s1weVooX5tLqTBnGBYMRtE-t",
        false,
        true
    )
    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadDetailTvShowAndBookmark(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailTv.title)))

//        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_genre)).check(matches(withText(dummyDetailTv.genre)))

        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailTv.sinopsis)))

        //Klik Button Bookmark dan kembali
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(pressBack())

        //Klik menu bookmark dan cek movie yang sama
        onView(withId(R.id.item_bookmark)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_bookmarktv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailTv.title)))
        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailTv.sinopsis)))
    }

    @Test
    fun loadDetailMovieAndBookmark(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailMove.title)))

//        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_genre)).check(matches(withText(dummyDetailMove.genre)))

        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailMove.sinopsis)))

        //Klik Button Bookmark dan kembali
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(pressBack())

        //Klik menu bookmark dan cek movie yang sama
        onView(withId(R.id.item_bookmark)).perform(click())
        onView(withId(R.id.rv_bookmarkmovies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailMove.title)))
        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailMove.sinopsis)))
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20)
        )
    }

    @Test
    fun loadTvShows(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20)
        )
    }
}