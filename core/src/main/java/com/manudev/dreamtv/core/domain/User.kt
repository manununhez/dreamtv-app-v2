package com.manudev.dreamtv.core.domain

data class User(
    val email: String,
    val password: String,
    val subtitleLanguage: String,
    val audioLanguage: String,
    val interfaceMode: String
)