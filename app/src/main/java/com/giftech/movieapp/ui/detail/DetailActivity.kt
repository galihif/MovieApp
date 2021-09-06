package com.giftech.movieapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_FILM = "EXTRA_FILM"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if(extras != null){
            val film = extras.getParcelable<FilmEntity>(EXTRA_FILM)
            populateView(film)
        }
    }

    private fun populateView(film: FilmEntity?) {
        with(binding){
            tvTitle.text = film?.title
            tvGenre.text = film?.genre
            tvSinopsis.text = film?.sinopsis

            Glide.with(this@DetailActivity)
                .load(film?.poster)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(ivPoster)
        }

        supportActionBar?.title = film?.title
    }
}