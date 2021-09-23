package com.dorizu.core.domain.model

data class Photo (
    val srcLarge: String,

    val srcMedium: String,

    val width: Int,

    val avgColor: String,

    val photographer: String,

    val photographerUrl: String,

    val id: Int,

    val url: String,

    val photographerId: Int,

    val liked: Boolean,

    val height: Int
)