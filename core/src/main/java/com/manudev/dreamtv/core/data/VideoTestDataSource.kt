package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.VideoTest

interface VideoTestDataSource {
    suspend fun add(videoTest: VideoTest)
    suspend fun remove(videoTest: VideoTest)
    suspend fun update(videoTest: VideoTest)
    suspend fun read(videoId: String): VideoTest
    suspend fun readAll(): List<VideoTest>
}