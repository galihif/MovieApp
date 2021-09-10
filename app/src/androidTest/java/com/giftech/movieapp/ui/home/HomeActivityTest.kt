package com.giftech.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.giftech.movieapp.R
import com.giftech.movieapp.data.FilmEntity
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
        title = "Don't Breathe 2",
        genre = "Thriller Horror ",
        sinopsis = "The Blind Man has been hiding out for several years in an isolated cabin and has taken in and raised a young girl orphaned from a devastating house fire. Their quiet life together is shattered when a group of criminals kidnap the girl, forcing the Blind Man to leave his safe haven to save her."
    )
    private val dummyTv = TvShowDummy.generateDummyTvShows()
    private val dummyDetailTv = FilmEntity(
        title = "What If...?",
        genre = "Animation Action & Adventure Sci-Fi & Fantasy ",
        sinopsis = "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory."
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

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailMove.title)))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyDetailMove.genre)))

        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailMove.sinopsis)))
    }
//
    @Test
    fun loadDetailTvShow(){
        onView(withText("TV Show")).perform(click())

        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailTv.title)))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyDetailTv.genre)))

        onView(withId(R.id.tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsis)).check(matches(withText(dummyDetailTv.sinopsis)))
    }
}