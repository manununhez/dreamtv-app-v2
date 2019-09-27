package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.UserTaskError

class UserTaskErrorRepository(private val dataSource: UserTaskErrorDataSource) {

    suspend fun addUserTaskError(userTaskError: UserTaskError) = dataSource.add(userTaskError)
    suspend fun updateUserTaskError(userTaskError: UserTaskError) = dataSource.update(userTaskError)
    suspend fun removeUserTaskError(userTaskError: UserTaskError) = dataSource.remove(userTaskError)
    suspend fun getUserTaskError(id: Int) = dataSource.read(id)
    suspend fun getUserTaskErrors() = dataSource.readAll()

}