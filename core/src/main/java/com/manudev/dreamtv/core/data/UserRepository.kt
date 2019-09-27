package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.User

class UserRepository(private val dataSource: UserDataSource) {

    suspend fun addUser(user: User) = dataSource.add(user)
    suspend fun removeUser(user: User) = dataSource.remove(user)
    suspend fun getUser(email: String) = dataSource.read(email)
    suspend fun getUsers() = dataSource.readAll()
    suspend fun updateUser(
        user: User
    ) = dataSource.update(user)


}