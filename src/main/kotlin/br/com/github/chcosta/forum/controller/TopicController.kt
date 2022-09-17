package br.com.github.chcosta.forum.controller

import br.com.github.chcosta.forum.dto.NewTopicForm
import br.com.github.chcosta.forum.dto.TopicView
import br.com.github.chcosta.forum.dto.UpdateTopicForm
import br.com.github.chcosta.forum.service.TopicService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

  @GetMapping
  fun listTopics(): List<TopicView> {
    return service.listTopics()
  }

  @GetMapping("/{id}")
  fun findTopicById(@PathVariable id: Long): TopicView {
    return service.findTopicById(id)
  }

  @PostMapping
  @Transactional
  fun createTopic(
      @RequestBody @Valid form: NewTopicForm,
      uriBuilder: UriComponentsBuilder
  ): ResponseEntity<TopicView> {
    val topicView: TopicView = service.createTopic(form)
    val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
    return ResponseEntity.created(uri).body(topicView)
  }

  @PutMapping
  @Transactional
  fun updateTopic(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
    val topicView: TopicView = service.updateTopic(form)
    return ResponseEntity.ok(topicView)
  }

  @Transactional
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteTopic(@PathVariable id: Long) {
    service.deleteTopic(id)
  }
}
