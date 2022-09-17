package br.com.github.chcosta.forum.repository

import br.com.github.chcosta.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
}