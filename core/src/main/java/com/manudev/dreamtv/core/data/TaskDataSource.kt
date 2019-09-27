package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.Task

interface TaskDataSource {

    suspend fun searchByTopic(topicName: String): List<Task>

    suspend fun search(query: String): List<Task>

    suspend fun add(task: Task)
    suspend fun remove(task: Task)
    suspend fun read(id: Int): Task
    suspend fun readAll(): List<Task>

    suspend fun readAllByCategory(category : String):List<Task>
}