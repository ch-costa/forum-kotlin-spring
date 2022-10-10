package br.com.github.chcosta.forum.dto

import br.com.github.chcosta.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
  val id: Long?,
  val title: String,
  val message: String,
  val status: TopicStatus,
  val creationDate: LocalDateTime
)
