package br.com.github.chcosta.forum.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import javax.persistence.*


@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val title: String,
    val message: String,
    @ManyToMany
    val course: Course?,
    @ManyToMany
    val author: User?,
    val creationDate: Instant = Clock.System.now(),
    @OneToMany(mappedBy = "topic")
    val answer: List<Answer> = ArrayList(),
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED
)
