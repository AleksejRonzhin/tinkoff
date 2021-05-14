package com.example.demo.api

import com.example.demo.dao.AuthorDAO
import com.example.demo.models.Author
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorController {

	@ApiOperation("Операция получения автора по id")
	@ApiResponses(
		ApiResponse(code = 200, message = "Автор найден и возвращен"),
		ApiResponse(code = 404, message = "Автор не найден")
	)
	@GetMapping("/{id}")
	fun getAuthorById(@ApiParam("id автора, которого нужно получить") @PathVariable id: Int): Author {
		val author = AuthorDAO.getAuthorById(id)
		if (author != null) {
			return author
		} else {
			throw MyException("Книги с id = $id не найдена")
		}
	}
}