package br.com.github.chcosta.forum.model

import kotlinx.datetime.LocalDateTime

data class Answer(
    val id: Long?,
    val message: String,
    val creationDate: LocalDateTime,
    val author: User,
    val topic: Topic,
    val solution: Boolean
)
