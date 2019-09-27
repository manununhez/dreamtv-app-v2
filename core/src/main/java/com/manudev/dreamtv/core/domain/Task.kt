package com.manudev.dreamtv.core.domain

data class Task(
    val id: Int,
    val video: Video,
    val subtitleLanguage: String
)