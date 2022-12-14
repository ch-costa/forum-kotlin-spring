package br.com.github.chcosta.forum.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_users")
data class User(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val name: String,
  val email: String
)
