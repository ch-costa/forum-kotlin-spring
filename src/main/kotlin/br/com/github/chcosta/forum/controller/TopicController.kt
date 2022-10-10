package br.com.github.chcosta.forum.controller

import br.com.github.chcosta.forum.dto.NewTopicForm
import br.com.github.chcosta.forum.dto.TopicView
import br.com.github.chcosta.forum.dto.UpdateTopicForm
import br.com.github.chcosta.forum.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

  @Cacheable("listOfTopics")
  @GetMapping
  fun listTopics(
    @RequestParam(required = false) courseName: String?,
    @PageableDefault(size = 6, sort = ["creationDate"], direction = Sort.Direction.DESC) pageable: Pageable
  ): Page<TopicView> {
    return service.listTopics(courseName, pageable)
  }

  @GetMapping("/{id}")
  fun findTopicById(@PathVariable id: Long): TopicView {
    return service.findTopicById(id)
  }

  @PostMapping
  @Transactional
  @CacheEvict(value = ["listOfTopics"], allEntries = true)
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
  @CacheEvict(value = ["listOfTopics"], allEntries = true)
  fun updateTopic(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {

    val topicView: TopicView = service.updateTopic(form)
    return ResponseEntity.ok(topicView)
  }

  @Transactional
  @DeleteMapping("/{id}")
  @CacheEvict(value = ["listOfTopics"], allEntries = true)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteTopic(@PathVariable id: Long) {
    service.deleteTopic(id)
  }
}
