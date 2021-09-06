package com.giftech.movieapp.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.FilmEntity
import com.giftech.movieapp.databinding.ItemFilmBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<FilmEntity>()

    fun setListTvShow(listTvShow:ArrayList<FilmEntity>){
        if(listTvShow == null) return

        this.listTvShow.clear()
        this.listTvShow.addAll(listTvShow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowAdapter.TvShowViewHolder {
        val itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowAdapter.TvShowViewHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class TvShowViewHolder(private val binding: ItemFilmBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(tvShow:FilmEntity){
            with(binding){
                tvItemTitle.text = tvShow.title
                tvItemGenre.text = tvShow.genre
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)
            }
        }

    }
}