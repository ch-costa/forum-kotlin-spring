package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.dto.NewTopicForm
import br.com.github.chcosta.forum.dto.TopicView
import br.com.github.chcosta.forum.dto.UpdateTopicForm
import br.com.github.chcosta.forum.exception.NotFoundException
import br.com.github.chcosta.forum.mapper.TopicFormMapper
import br.com.github.chcosta.forum.mapper.TopicViewMapper
import br.com.github.chcosta.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
) {

  private val notFoundMessage: String = "Topic not found"
  fun listTopics(): List<TopicView> {

    return topics.map { topic: Topic -> topicViewMapper.map(topic) }
  }

  fun findTopicById(topicId: Long): TopicView? {

    return topics.find { topic: Topic -> topic.id == topicId }?.run { topicViewMapper.map(this) }
  }

  fun createTopic(form: NewTopicForm): TopicView {

    val topic = topicFormMapper.map(form)

    topic.id = topics.size.toLong() + 1
    topics = topics.plus(topic)

    return topicViewMapper.map(topic)
  }

  fun updateTopic(form: UpdateTopicForm): TopicView {

    val topic =
        topics.stream().filter { t -> t.id == form.id }.findFirst().orElseThrow {
          NotFoundException(notFoundMessage)
        }
    val newTopic =
        Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            course = topic.course,
            author = topic.author,
            answer = topic.answer,
            creationDate = topic.creationDate,
            status = topic.status
        )
    topics = topics.minus(topic).plus(newTopic).sortedBy { topic: Topic -> topic.id }

    return topicViewMapper.map(newTopic)
  }

  fun deleteTopic(id: Long) {
    topics = topics.run { minus(this.filter { topic: Topic -> topic.id == id }.toSet()) }
  }
}
