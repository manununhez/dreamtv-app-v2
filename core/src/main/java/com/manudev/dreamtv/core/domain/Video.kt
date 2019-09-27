package com.manudev.dreamtv.core.domain

data class Video(
    val id: String,
    val audioLanguage: String,
    val speakerName: String,
    val title: String,
    val description: String,
    val duration: Int,
    val thumbnail: String,
    val team: String,
    val project: String,
    val videoUrl: String
)
