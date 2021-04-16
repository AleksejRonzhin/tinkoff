package com.example.demo.api

import com.example.demo.dao.AuthorDAO
import com.example.demo.models.Author
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorController {

	@GetMapping("/{id}")
	fun getAuthorById(@PathVariable id: Int): Author {
		val author = AuthorDAO.getAuthorById(id)
		if (author != null) {
			return author
		} else {
			throw MyException("Книги с id = $id не найдена")
		}
	}
}