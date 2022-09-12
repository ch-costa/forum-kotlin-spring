package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.model.Course
import java.util.*
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {

  init {

    val course = Course(id = 1, name = "Kotlin", category = "Programação")

    courses = Arrays.asList(course)
  }

  fun findeCourseById(id: Long): Course? {
    return courses.find { course: Course -> course.id == id }
  }
}
