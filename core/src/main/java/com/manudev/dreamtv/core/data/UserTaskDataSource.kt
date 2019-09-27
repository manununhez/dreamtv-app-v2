package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.UserTask

interface UserTaskDataSource {
    suspend fun add(userTask: UserTask)
    suspend fun update(userTask: UserTask)
    suspend fun remove(userTask: UserTask)
    suspend fun read(taskId: Int): UserTask
    suspend fun readAll(): List<UserTask>

//    suspend fun add(
//        taskId: Int,
//        subtitleVersion: Int
//    ): UserTask
//
//    suspend fun update(
//        taskId: Int,
//        subtitleVersion: Int,
//        timeWatched: Int,
//        completed: Boolean
//    ): UserTask
}