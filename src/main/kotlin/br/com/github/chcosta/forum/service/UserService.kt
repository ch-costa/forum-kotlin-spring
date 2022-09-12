package br.com.github.chcosta.forum.service

import br.com.github.chcosta.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<User>) {

  init {

    val user = User(id = 1, name = "Ana da Silva", email = "ana@email.com.br")
  }

  fun findeAuthorById(id: Long): User? {
    return users.find { user: User -> user.id == id }
  }
}
