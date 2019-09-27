package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.Subtitle

class SubtitleRepository(private val dataSource: SubtitleDataSource) {

    suspend fun addSubtitle(subtitle: Subtitle) = dataSource.add(subtitle)
    suspend fun removeSubtitle(subtitle: Subtitle) = dataSource.remove(subtitle)
    suspend fun getSubtitle(
        videoId: String,
        language: String,
        version: Int
    ) = dataSource.read(videoId, language, version)

    suspend fun getSubtitles() = dataSource.readAll()
}