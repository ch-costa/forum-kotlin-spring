package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.model.Course
import org.springframework.stereotype.Service
import br.com.github.chcosta.forum.repository.CourseRepository

@Service
class CourseService(private val repository: CourseRepository) {

  fun findeCourseById(id: Long): Course {
    return repository.getReferenceById(id)
  }
}
