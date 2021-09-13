package com.giftech.movieapp.ui.bookmarkmovies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.databinding.ItemFilmBinding
import com.giftech.movieapp.ui.detail.DetailActivity

class BookmarkMoviesAdapter: RecyclerView.Adapter<BookmarkMoviesAdapter.BookmarkMovieViewHolder>() {

    private var listBookmarkMovies = ArrayList<FilmEntity>()

    fun setList(list: List<FilmEntity>){
        this.listBookmarkMovies.clear()
        this.listBookmarkMovies.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkMovieViewHolder {
        val itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookmarkMovieViewHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: BookmarkMovieViewHolder, position: Int) {
        val movie = listBookmarkMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listBookmarkMovies.size

    class BookmarkMovieViewHolder(private val binding: ItemFilmBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(movie:FilmEntity){
            with(binding){
                tvItemTitle.text = movie.title
//                tvItemGenre.text = movie.genre
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.id)
                    intent.putExtra(DetailActivity.IS_MOVIE, true)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}