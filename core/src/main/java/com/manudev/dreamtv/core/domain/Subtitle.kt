package com.manudev.dreamtv.core.domain

data class Subtitle(
    val version: Int,
    val videoTitleOriginal: String,
    val videoTitleTranslated: String,
    val videoDescriptionOriginal: String,
    val videoDescriptionTranslated: String,
    val subtitles: List<SubtitleData>
)


data class SubtitleData(
    val text: String,
    val position: Int,
    val start: Int,
    val end: Int
)