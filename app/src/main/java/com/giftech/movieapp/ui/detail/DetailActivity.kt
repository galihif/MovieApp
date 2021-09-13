package com.giftech.movieapp.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.databinding.ActivityDetailBinding
import com.giftech.movieapp.viewmodel.ViewModelFactory
import com.giftech.movieapp.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_FILM = "EXTRA_FILM"
        const val IS_MOVIE = "IS_MOVIE"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            val isMovie = extras.getBoolean(IS_MOVIE)
            val filmId = extras.getInt(EXTRA_FILM)

            if(isMovie){
                viewModel.getMovieById(filmId).observe(this, {movieRes ->
                    if(movieRes!=null){
                        when(movieRes.status){
                            Status.SUCCESS -> {
                                populateView(movieRes.data)
                            }
                        }
                    }
                })
            }else{
                viewModel.getTvById(filmId).observe(this, {tvRes ->
                    if(tvRes!=null){
                        when(tvRes.status){
                            Status.SUCCESS -> {
                                populateView(tvRes.data)
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateView(film: FilmEntity?) {
        with(binding){
            tvTitle.text = film?.title
//            tvGenre.text = film?.genre
            tvSinopsis.text = film?.sinopsis

            Glide.with(this@DetailActivity)
                .load(film?.poster)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(ivPoster)

            setBookmarkBtn(film!!)

            btnBookmark.setOnClickListener {
                film.bookmarked = !film.bookmarked!!
                if(film.bookmarked!!){
                    Toast.makeText(this@DetailActivity,"Film ${film.title} disimpan ke bookmark",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@DetailActivity,"Film ${film.title} dihapus dari bookmark",Toast.LENGTH_LONG).show()
                }
                setBookmarkBtn(film)
            }
        }

        supportActionBar?.title = film?.title
    }

    private fun setBookmarkBtn(film:FilmEntity){
        with(binding){
            if(film.bookmarked!!){
                btnBookmark.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_bookmark,0,0,0)
                btnBookmark.text = "Unbookmark this film"
            }else{
                btnBookmark.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_bookmark_outline,0,0,0)
                btnBookmark.text = "Bookmark this film"
            }
        }

    }
}