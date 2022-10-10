package br.com.github.chcosta.forum.repository

import br.com.github.chcosta.forum.dto.TopicByCategory
import br.com.github.chcosta.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {

  fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

  @Query("SELECT new br.com.github.chcosta.forum.dto.TopicByCategory(course.category, COUNT(t)) FROM Topic t JOIN t.course  course GROUP BY course.category")
  fun reportOfTopics(): List<TopicByCategory>
}