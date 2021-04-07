package DAO

import models.Author

class AuthorDAO {
	companion object {
		private val authorList = listOf(
			Author(1, "Достоевский", 1821),
			Author(2, "Булгаков", 1891),
			Author(3, "Пушкин", 1799),
		)

		fun getAuthorById(id: Int): Author? = authorList.find { it.id == id }
	}
}