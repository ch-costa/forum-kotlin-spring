package br.com.github.chcosta.forum.mapper

interface Mapper<T, U> {

  fun map(t: T): U
}
