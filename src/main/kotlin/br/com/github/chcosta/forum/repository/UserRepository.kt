package br.com.github.chcosta.forum.repository

import br.com.github.chcosta.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}