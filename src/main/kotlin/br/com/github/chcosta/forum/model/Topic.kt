package br.com.github.chcosta.forum.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "tb_topics")
data class Topic(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,
  var title: String,
  var message: String,
  @ManyToOne
  val course: Course,
  @ManyToOne
  val author: User,
  val creationDate: LocalDateTime = LocalDateTime.now(),
  @OneToMany(mappedBy = "topic")
  val answer: List<Answer> = ArrayList(),
  @Enumerated(value = EnumType.STRING)
  val status: TopicStatus = TopicStatus.NOT_ANSWERED
)
