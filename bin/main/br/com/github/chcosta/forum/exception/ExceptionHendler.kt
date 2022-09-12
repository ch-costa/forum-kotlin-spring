package br.com.github.chcosta.forum.exception

import br.com.github.chcosta.forum.dto.ErrorView
import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHendler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException::class)
  fun hendleNotFound(exception: NotFoundException, request: HttpServletRequest): ErrorView {

    return ErrorView(
        status = HttpStatus.NOT_FOUND.value(),
        error = HttpStatus.NOT_FOUND.name,
        message = exception.message,
        path = request.servletPath
    )
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception::class)
  fun hendleServerError(exception: Exception, request: HttpServletRequest): ErrorView {

    return ErrorView(
        status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
        error = HttpStatus.INTERNAL_SERVER_ERROR.name,
        message = exception.message,
        path = request.servletPath
    )
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun hendleValidationError(
      exception: MethodArgumentNotValidException,
      request: HttpServletRequest
  ): ErrorView {

    val errorMessage = HashMap<String, String?>()
    exception.bindingResult.fieldErrors.forEach { e -> errorMessage.put(e.field, e.defaultMessage) }
    return ErrorView(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.name,
        message = errorMessage.toString(),
        path = request.servletPath
    )
  }
}
