package com.example.demo.dao

import com.example.demo.models.Author

class AuthorDAO {
	companion object {
		private val authorList = listOf(
			Author(0, "Достоевский", 1821),
			Author(1, "Булгаков", 1891),
			Author(2, "Пушкин", 1799),
		)

		fun getAuthorById(id: Int): Author? = authorList.find { it.id == id }
	}
}