package com.manudev.dreamtv.core.data

class AuthenticationRepository(private val dataSource: AuthenticationDataSource) {

    suspend fun login(
        email: String,
        password: String
    ) = dataSource.login(email, password)

    suspend fun register(
        email: String,
        password: String
    ) = dataSource.register(email, password)

}