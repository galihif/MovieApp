package com.giftech.movieapp.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.databinding.ItemFilmBinding

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<FilmEntity>()

    fun setListMovie(listMovie:ArrayList<FilmEntity>){
        if(listMovie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MovieViewHolder {
        val itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemFilmBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(movie: FilmEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)
            }
        }

    }
}