package br.com.github.chcosta.forum.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import javax.persistence.*

@Entity
data class Answer(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val message: String,
  val creationDate: Instant = Clock.System.now(),
  @ManyToOne
  val author: User,
  @ManyToOne
  val topic: Topic,
  val solution: Boolean
)
