package br.com.github.chcosta.forum.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val course: Course?,
    val author: User?,
    val creationDate: Instant = Clock.System.now(),
    val answer: List<Answer> = ArrayList(),
    val status: TopicStatus = TopicStatus.NOT_ANSWERED
)
