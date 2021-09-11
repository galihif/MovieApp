package com.giftech.movieapp.ui.bookmark

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.giftech.movieapp.ui.bookmarkmovies.BookmarkMoviesFragment
import com.giftech.movieapp.ui.bookmarktvshow.BookmarkTvshowFragment

class BookmarkSectionsPagerAdapter(private val mContext:Context, fm:FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {

        private val TAB_TITLES = arrayListOf("Movies", "TV Show")
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> BookmarkMoviesFragment()
            1 -> BookmarkTvshowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = TAB_TITLES[position]

}