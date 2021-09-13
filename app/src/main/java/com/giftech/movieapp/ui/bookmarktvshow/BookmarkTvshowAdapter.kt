package com.giftech.movieapp.ui.bookmarktvshow

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

class BookmarkTvshowAdapter: RecyclerView.Adapter<BookmarkTvshowAdapter.BookmarkTvViewHolder>() {

    private var listBookmarkTv= ArrayList<FilmEntity>()

    fun setList(list: List<FilmEntity>){
        this.listBookmarkTv.clear()
        this.listBookmarkTv.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkTvViewHolder {
        val itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookmarkTvshowAdapter.BookmarkTvViewHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: BookmarkTvViewHolder, position: Int) {
        val tvShow = listBookmarkTv[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listBookmarkTv.size

    class BookmarkTvViewHolder(private val binding: ItemFilmBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow:FilmEntity){
            with(binding){
                tvItemTitle.text = tvShow.title
//                tvItemGenre.text = tvShow.genre
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow.id)
                    intent.putExtra(DetailActivity.IS_MOVIE, true)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}