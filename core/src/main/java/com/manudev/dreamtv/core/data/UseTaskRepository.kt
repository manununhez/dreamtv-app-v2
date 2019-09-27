package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.UserTask

class UseTaskRepository(private val dataSource: UserTaskDataSource) {

    suspend fun addUserTask(userTask: UserTask) =
        dataSource.add(userTask)

    suspend fun removeUserTask(userTask: UserTask) =
        dataSource.remove(userTask)

    suspend fun updateUserTask(userTask: UserTask) =
        dataSource.update(userTask)

    suspend fun getUserTask(taskId: Int) = dataSource.read(taskId)
    suspend fun getUserTasks() = dataSource.readAll()
}