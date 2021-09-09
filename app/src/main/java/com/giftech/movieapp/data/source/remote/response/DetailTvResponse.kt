package com.giftech.movieapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailTvResponse(

	@field:SerializedName("genres")
	val genres: List<TvGenresItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

)

data class TvGenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

