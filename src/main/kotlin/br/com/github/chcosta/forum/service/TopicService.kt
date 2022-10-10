package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.dto.NewTopicForm
import br.com.github.chcosta.forum.dto.TopicByCategory
import br.com.github.chcosta.forum.dto.TopicView
import br.com.github.chcosta.forum.dto.UpdateTopicForm
import br.com.github.chcosta.forum.exception.NotFoundException
import br.com.github.chcosta.forum.mapper.TopicFormMapper
import br.com.github.chcosta.forum.mapper.TopicViewMapper
import br.com.github.chcosta.forum.model.Topic
import br.com.github.chcosta.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
  private val repository: TopicRepository,
  private val topicViewMapper: TopicViewMapper,
  private val topicFormMapper: TopicFormMapper,
) {

  private val notFoundMessage: String = "Topic not found"
  fun listTopics(
    courseName: String?,
    pageable: Pageable
  ): Page<TopicView> {

    val topics =
      if (courseName == null) repository.findAll(pageable) else repository.findByCourseName(courseName, pageable)
    return topics.map { topic: Topic -> topicViewMapper.map(topic) }
  }

  fun findTopicById(topicId: Long): TopicView {

    val topic: Topic = repository.getReferenceById(topicId)
    return topicViewMapper.map(topic)
  }

  fun createTopic(form: NewTopicForm): TopicView {

    val topic: Topic = topicFormMapper.map(form)
    repository.save(topic)
    return topicViewMapper.map(topic)
  }

  fun updateTopic(form: UpdateTopicForm): TopicView {

    val topic: Topic = repository.findById(form.id).orElseThrow {
      NotFoundException(notFoundMessage)
    }

    topic.title = form.title
    topic.message = form.message
    return topicViewMapper.map(topic)
  }

  fun deleteTopic(id: Long) {
    repository.deleteById(id)
  }

  fun reportOfTopics(): List<TopicByCategory> {
    return repository.reportOfTopics()
  }
}
