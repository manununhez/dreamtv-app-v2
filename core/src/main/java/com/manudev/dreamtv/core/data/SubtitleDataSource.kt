package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.Subtitle

interface SubtitleDataSource {

    suspend fun add(subtitle: Subtitle)
    suspend fun remove(subtitle: Subtitle)
    suspend fun read(
        videoId: String,
        language: String,
        version: Int
    ): Subtitle

    suspend fun readAll(
    ): List<Subtitle>


}