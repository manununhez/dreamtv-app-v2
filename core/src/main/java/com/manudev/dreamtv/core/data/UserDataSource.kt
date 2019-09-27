package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.User

interface UserDataSource {

    suspend fun add(user: User)
    suspend fun remove(user: User)
    suspend fun update(user: User): User
    suspend fun read(email: String): User
    suspend fun readAll(): List<User>

}