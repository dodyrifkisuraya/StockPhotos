package com.dorizu.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class CuratedResponse(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("photos")
	val photos: List<PhotosItemResponse>
)

data class PhotosItemResponse(

	@field:SerializedName("src")
	val src: TypeSrcResponse,

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("avg_color")
	val avgColor: String,

	@field:SerializedName("photographer")
	val photographer: String,

	@field:SerializedName("photographer_url")
	val photographerUrl: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("photographer_id")
	val photographerId: Int,

	@field:SerializedName("liked")
	val liked: Boolean,

	@field:SerializedName("height")
	val height: Int
)

data class TypeSrcResponse(

	@field:SerializedName("small")
	val small: String,

	@field:SerializedName("original")
	val original: String,

	@field:SerializedName("large")
	val large: String,

	@field:SerializedName("tiny")
	val tiny: String,

	@field:SerializedName("medium")
	val medium: String,

	@field:SerializedName("large2x")
	val large2x: String,

	@field:SerializedName("portrait")
	val portrait: String,

	@field:SerializedName("landscape")
	val landscape: String
)
