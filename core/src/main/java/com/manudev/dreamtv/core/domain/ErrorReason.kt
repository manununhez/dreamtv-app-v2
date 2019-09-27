package com.manudev.dreamtv.core.domain

data class ErrorReason(
    val code: String,
    val name: String,
    val description: String,
    val language: String
)