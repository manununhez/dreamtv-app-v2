package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.VideoTopic

class VideoTopicRepositoy(private val dataSource: VideoTopicDataSource) {

    suspend fun getVideoTopics() = dataSource.readAll()
    suspend fun getVideoTopic(id: Int) = dataSource.read(id)
    suspend fun addVideoTopic(videoTopic: VideoTopic) = dataSource.add(videoTopic)
    suspend fun removeVideoTopic(videoTopic: VideoTopic) = dataSource.remove(videoTopic)
    suspend fun updateVideoTopic(videoTopic: VideoTopic) = dataSource.update(videoTopic)
}