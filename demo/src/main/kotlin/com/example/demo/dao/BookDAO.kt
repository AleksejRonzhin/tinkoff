package com.example.demo.dao

import com.example.demo.models.Book

class BookDAO {
	companion object {
		private val bookList = listOf(
			Book(0, "Преступление и наказание", 0, 2002),
			Book(1, "Идиот", 0, 2001),
			Book(2, "Мастер и Маргарита", 1, 2001),
			Book(3, "Капитанская дочка", 2, 2003)
		)

		fun getAllBooks() = this.bookList

		fun getBookById(id: Int): Book? = this.bookList.find { it.id == id }
	}
}