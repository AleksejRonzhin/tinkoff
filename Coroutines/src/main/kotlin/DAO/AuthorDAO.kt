package DAO

import models.Author

class AuthorDAO {
	companion object {
		val authorList = listOf(
			Author(1, "Достоевский", 1821),
			Author(2, "Булгаков", 1891),
			Author(3, "Пушкин", 1799),
		)
	}
}