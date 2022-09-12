package br.com.github.chcosta.forum.mapper

import br.com.github.chcosta.forum.dto.NewTopicForm
import br.com.github.chcosta.forum.model.Topic
import br.com.github.chcosta.forum.service.CourseService
import br.com.github.chcosta.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicForm, Topic> {

  override fun map(form: NewTopicForm): Topic {
    return Topic(
        title = form.title,
        message = form.message,
        course = courseService.findeCourseById(form.courseId),
        author = userService.findeAuthorById(form.authorId)
    )
  }
}
