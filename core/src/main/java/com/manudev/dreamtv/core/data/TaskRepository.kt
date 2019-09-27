package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.Task

class TaskRepository(private val dataSource: TaskDataSource) {

    suspend fun searchTasks(
        query: String
    ) = dataSource.search(query)

    suspend fun searchTasksByTopic(
        topicName: String
    ) = dataSource.searchByTopic(topicName)

    suspend fun addTask(task: Task) = dataSource.add(task)
    suspend fun removeTask(task: Task) = dataSource.remove(task)
    suspend fun getTask(id: Int) = dataSource.read(id)
    suspend fun getTasks() = dataSource.readAll()
    suspend fun getTasksByCategory(category: String) = dataSource.readAllByCategory(category)

}