package br.com.github.chcosta.forum.mapper

import br.com.github.chcosta.forum.dto.TopicView
import br.com.github.chcosta.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

  override fun map(t: Topic): TopicView {

    return TopicView(
        id = t.id,
        title = t.title,
        message = t.message,
        status = t.status,
        creationDate = t.creationDate
    )
  }
}
