import DAO.AuthorDAO
import DAO.BookDAO
import models.AuthorWithBooks
import kotlinx.coroutines.*
import models.Author
import models.Book

class AuthorWithBooksService {
	companion object {

		suspend fun getAuthorWithBooks(id: Int) = runBlocking {
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

		private fun getAllBooksAuthor(authorId: Int): List<Book> = BookDAO.getAllBooksAuthor(authorId)

		private fun getAuthor(id: Int): Author? = AuthorDAO.getAuthorById(id)

	}
}
