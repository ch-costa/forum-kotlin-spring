package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.model.User
import org.springframework.stereotype.Service
import br.com.github.chcosta.forum.repository.UserRepository

@Service
class UserService(private val repository: UserRepository) {

  fun findeAuthorById(id: Long): User {
    return repository.getReferenceById(id)
  }
}
