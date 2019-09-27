package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.ErrorReason

interface ErrorReasonDataSource {
    suspend fun add(errorReason: ErrorReason)
    suspend fun remove(errorReason: ErrorReason)
    suspend fun read(code: String): ErrorReason
    suspend fun readAll(): List<ErrorReason>
}