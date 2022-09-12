package br.com.github.chcosta.forum.dto

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class ErrorView(
    val timesTamp: Instant = Clock.System.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
