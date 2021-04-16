package com.example.demo.api

import com.example.demo.dao.AuthorDAO
import com.example.demo.dao.BookDAO
import com.example.demo.models.Book
import com.example.demo.models.BookWithAuthor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController {

	@GetMapping("/{id}")
	fun getBookById(@PathVariable id: Int): Book {
		val book = BookDAO.getBookById(id)
		if (book != null){
			return book
		} else {
			throw MyException("Книги с id = $id не найдено")
		}
	}

	@GetMapping
	fun getAllBooks(): List<BookWithAuthor> {
		return BookDAO.getAllBooks().map {
			val author = AuthorDAO.getAuthorById(it.authorId)
			BookWithAuthor(it.id, it.name, author!!.name, it.year)
		}
	}

	@PostMapping
	fun addBook(@RequestBody book: Book): ResponseEntity<String> {
		return ResponseEntity("Добавлена книга $book", HttpStatus.OK)
	}

	@PutMapping("/{id}")
	fun updateBook(@PathVariable id: Int, @RequestBody book: Book): ResponseEntity<String> {
		val sourceBook = BookDAO.getBookById(id)
		return if (sourceBook != null){
			ResponseEntity("Обновлена книга c номером $id: $book", HttpStatus.OK)
		} else {
			throw MyException("Книги с id = $id не найдено")
//			ResponseEntity("Книги с id = $id не нашлось", HttpStatus.NOT_FOUND)
		}
	}

	@DeleteMapping("/{id}")
	fun deleteBook(@PathVariable id: Int): ResponseEntity<String> {
		val book = BookDAO.getBookById(id)
		return if (book != null){
			ResponseEntity("Удалена книга c id = $id", HttpStatus.OK)
		} else {
			throw MyException("Книги с id = $id не найдено")
//			ResponseEntity("Книги с id = $id не нашлось", HttpStatus.NOT_FOUND)
		}
	}
}