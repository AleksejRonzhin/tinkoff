package com.example.demo.dao

import com.example.demo.models.Book

class BookDAO {
	companion object {
		private val bookList = listOf(
			Book(1, "Преступление и наказание", 1, 2002),
			Book(2, "Идиот", 1, 2001),
			Book(3, "Мастер и Маргарита", 2, 2001),
			Book(4, "Капитанская дочка", 3, 2003)
		)

		fun getAllBooksAuthor(authorId: Int) = bookList.filter { it.authorId == authorId }

		fun getAllBooks() = this.bookList

		fun getBookById(id: Int) = bookList.find { it.id == id }
	}
}