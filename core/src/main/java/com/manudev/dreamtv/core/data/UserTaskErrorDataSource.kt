package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.UserTaskError

interface UserTaskErrorDataSource {

    suspend fun add(userTaskError: UserTaskError)
    suspend fun remove(userTaskError: UserTaskError)
    suspend fun update(userTaskError: UserTaskError)
    suspend fun read(id: Int): UserTaskError
    suspend fun readAll(): List<UserTaskError>

//    suspend fun add(
//        taskId: Int,
//        errorReasonCode: String,
//        subtitlePosition: Int,
//        subtitleVersion: Int
//    ): List<UserTaskError>
//
//    suspend fun update(
//        taskId: Int,
//        errorReasonCode: String,
//        subtitlePosition: Int,
//        subtitleVersion: Int
//    ): List<UserTaskError>
}