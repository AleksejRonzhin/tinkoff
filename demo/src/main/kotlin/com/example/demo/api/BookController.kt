package com.example.demo.api

import com.example.demo.dao.BookDAO
import com.example.demo.models.Book
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController {

	@GetMapping
	fun getAllBooks(): List<Book>{
		return BookDAO.getAllBooks()
	}

	@PostMapping
	fun addBook(book: Book){
		println("Добавлена книга $book")
	}

	@PutMapping("/{id}")
	fun updateBook(id: Int, book: Book){
		println("Обновлена книга c номером $id: $book")
	}

	@DeleteMapping("/{id}")
	fun deleteBook(id: Int){
		println("Удалена книга c id = $id")
	}
}