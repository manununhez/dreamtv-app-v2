package com.manudev.dreamtv.core.domain

data class UserTaskError(
    val id: Int,
    val errorReasonCode: String,
    val subtitlePosition: Int,
    val comment: String
)
