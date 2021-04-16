package com.example.demo.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionHandler {

	@ExceptionHandler(MyException::class)
	fun handleException(ex: MyException, request: WebRequest): ResponseEntity<String> {
		return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
	}

}