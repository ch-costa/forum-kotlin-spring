package br.com.github.chcosta.forum.model

import javax.persistence.*

@Entity
@Table(name = "tb_courses")
data class Course(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val name: String,
  val category: String
)
