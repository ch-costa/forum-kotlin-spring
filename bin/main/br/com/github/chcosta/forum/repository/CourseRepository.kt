package br.com.github.chcosta.forum.repository

import br.com.github.chcosta.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
}