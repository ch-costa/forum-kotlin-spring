package br.com.github.chcosta.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_answer")
data class Answer(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val message: String,
  val creationDate: LocalDateTime = LocalDateTime.now(),
  @ManyToOne
  val author: User,
  @ManyToOne
  val topic: Topic,
  val solution: Boolean
)
