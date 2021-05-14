package com.example.demo.api

import com.example.demo.dao.BookDAO
import com.example.demo.models.Author
import com.example.demo.models.Book
import com.example.demo.models.BookWithAuthor
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/book")
class BookController {

    private val webClient = WebClient.create("http://localhost:8080")

    @ApiOperation("Операция получения книги по id")
    @ApiResponses(
        ApiResponse(code = 200, message = "Книга найдена и возвращена"),
        ApiResponse(code = 404, message = "Книга не найдена")
    )
    @GetMapping("/{id}")
    fun getBookById(@ApiParam("id книги, которую нужно получить") @PathVariable id: Int): Book {
        val book = BookDAO.getBookById(id)
        if (book != null) {
            return book
        } else {
            throw MyException("Книги с id = $id не найдено")
        }
    }

    @ApiOperation("Операция получения всех книг с именами авторов")
    @GetMapping
    fun getAllBooks(): List<BookWithAuthor> {
        return BookDAO.getAllBooks().map {
            val author = getAuthorWebClient(it.authorId)
            BookWithAuthor(it.id, it.name, author!!.name, it.year)
        }
    }

    fun getAuthorWebClient(id: Int): Author? =
        webClient
            .get()
            .uri("/author/$id")
            .retrieve()
            .bodyToMono(Author::class.java)
            .block()

    @ApiOperation("Операция добавления книги")
    @PostMapping
    fun addBook(@ApiParam("книга, которую нужно добавить") @RequestBody book: Book): ResponseEntity<String> {
        return ResponseEntity("Добавлена книга $book", HttpStatus.OK)
    }

    @ApiOperation("Операция обновления книги")
    @ApiResponses(
        ApiResponse(code = 200, message = "Книга найдена и обновлена"),
        ApiResponse(code = 404, message = "Книга не найдена")
    )
    @PutMapping("/{id}")
    fun updateBook(
        @ApiParam("id книги, которую нужно изменить") @PathVariable id: Int,
        @ApiParam("экземпляр книги с изменениями") @RequestBody book: Book,
    ): ResponseEntity<String> {
        val sourceBook = BookDAO.getBookById(id)
        return if (sourceBook != null) {
            ResponseEntity("Обновлена книга c номером $id: $book", HttpStatus.OK)
        } else {
            throw MyException("Книги с id = $id не найдена")
        }
    }

    @ApiOperation("Операция удаления книги")
    @ApiResponses(
        ApiResponse(code = 200, message = "Книга найдена и удалена"),
        ApiResponse(code = 404, message = "Книга не найдена")
    )
    @DeleteMapping("/{id}")
    fun deleteBook(@ApiParam("id книги, которую нужно удалить") @PathVariable id: Int): ResponseEntity<String> {
        val book = BookDAO.getBookById(id)
        return if (book != null) {
            ResponseEntity("Удалена книга c id = $id", HttpStatus.OK)
        } else {
            throw MyException("Книги с id = $id не найдена")
        }
    }
}