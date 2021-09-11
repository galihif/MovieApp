package com.giftech.movieapp.ui.bookmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giftech.movieapp.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {

    private lateinit var bookmarkBinding: ActivityBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookmarkBinding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(bookmarkBinding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Bookmark"
    }
}