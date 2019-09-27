package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.VideoTopic

interface VideoTopicDataSource {
    suspend fun add(videoTopic: VideoTopic)
    suspend fun remove(videoTopic: VideoTopic)
    suspend fun update(videoTopic: VideoTopic)
    suspend fun read(id: Int): VideoTopic
    suspend fun readAll(): List<VideoTopic>

}