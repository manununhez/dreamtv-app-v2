package com.manudev.dreamtv.core.domain

data class UserTask(
    val id: Int,
    val userId: Int,
    val taskId: Int,
    val subtitleVersion: Int,
    val completed: Boolean,
    val rating: Int,
    val timeWatched: Int,
    val userTaskErrors: List<UserTaskError>
)