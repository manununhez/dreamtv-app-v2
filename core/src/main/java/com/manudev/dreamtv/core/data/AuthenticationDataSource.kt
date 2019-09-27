package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.Authentication

interface AuthenticationDataSource {

    suspend fun login(email: String, password: String): Authentication

    suspend fun register(email: String, password: String): Authentication

}