package com.giftech.movieapp.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.giftech.movieapp.ui.movies.MoviesFragment
import com.giftech.movieapp.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(private val mContext:Context, fm:FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {

        private val TAB_TITLES = arrayListOf("Movies", "TV Show")
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> MoviesFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = TAB_TITLES[position]

}