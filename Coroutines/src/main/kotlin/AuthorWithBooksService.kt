import DAO.AuthorDAO
import DAO.BookDAO
import models.AuthorWithBooks
import kotlinx.coroutines.*
import models.Author
import models.Book

class AuthorWithBooksService {
	companion object {

		suspend fun getAuthorWithBooks(id: Int): AuthorWithBooks = runBlocking {
			val authorJob = async { getAuthor(id) }
			val booksJob = async { getAllBooksAuthor(id) }
			val author = authorJob.await()
			val books = booksJob.await()
			AuthorWithBooks(
				author!!.id,
				author.name,
				author.birthYear,
				books.map { it.id }
			)
		}

		private suspend fun getAllBooksAuthor(authorId: Int): List<Book> {
			delay(1000)
			return BookDAO.getAllBooksAuthor(authorId)
		}


		private suspend fun getAuthor(id: Int): Author? {
			delay(1000)
			return AuthorDAO.getAuthorById(id)
		}

	}
}
