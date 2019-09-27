package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.VideoTest

class VideoTestRepository(private val dataSource: VideoTestDataSource) {

    suspend fun addVideoTest(videoTest: VideoTest) = dataSource.add(videoTest)
    suspend fun removeVideoTest(videoTest: VideoTest) = dataSource.remove(videoTest)
    suspend fun updateVideoTest(videoTest: VideoTest) = dataSource.update(videoTest)
    suspend fun getVideoTests() = dataSource.readAll()
    suspend fun getVideoTest(videoId: String) = dataSource.read(videoId)
}