import DAO.AuthorDAO
import DAO.BookDAO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import models.Author
import models.AuthorWithBooks
import models.Book

class AuthorWithBooksService {
    companion object {

        suspend fun getAuthorWithBooks(id: Int): AuthorWithBooks? = runBlocking {
            val authorJob = async { getAuthor(id) }
            val booksJob = async { getAllBooksAuthor(id) }
            val author = authorJob.await()
            val books = booksJob.await()
            if (author != null) {
                AuthorWithBooks(
                    author.id,
                    author.name,
                    author.birthYear,
                    books.map { it.id }
                )
            } else {
                null
            }
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
