package com.manudev.dreamtv.core.data

import com.manudev.dreamtv.core.domain.ErrorReason

class ErrorReasonRepository(private val dataSource: ErrorReasonDataSource) {

    suspend fun addErrorReasons(errorReason: ErrorReason) = dataSource.add(errorReason)
    suspend fun removeErrorReasons(errorReason: ErrorReason) = dataSource.remove(errorReason)
    suspend fun getErrorReason(code: String) = dataSource.read(code)
    suspend fun getErrorReasons() = dataSource.readAll()
}