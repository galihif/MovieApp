package com.giftech.movieapp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giftech.movieapp.R
import com.giftech.movieapp.data.source.local.entity.FilmEntity
import com.giftech.movieapp.databinding.ItemFilmBinding
import com.giftech.movieapp.ui.detail.DetailActivity

class TvShowAdapter: PagedListAdapter<FilmEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    private var listTvShow = ArrayList<FilmEntity>()

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>() {
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

//    fun setListTvShow(listTvShow:List<FilmEntity>){
//        this.listTvShow.clear()
//        this.listTvShow.addAll(listTvShow)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

//    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemFilmBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(tvShow: FilmEntity){
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
                    intent.putExtra(DetailActivity.IS_MOVIE, false)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}