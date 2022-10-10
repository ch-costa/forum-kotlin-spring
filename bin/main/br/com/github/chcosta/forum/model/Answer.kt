package br.com.github.chcosta.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_answers")
data class Answer(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val message: String,
  @Column(name = "creation_date")
  val creationDate: LocalDateTime = LocalDateTime.now(),
  @ManyToOne
  val author: User,
  @ManyToOne
  val topic: Topic,
  val solution: Boolean
)
