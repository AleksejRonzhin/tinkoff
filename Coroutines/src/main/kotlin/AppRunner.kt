import DAO.BookDAO
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking{
	println(AuthorWithBooksService.getAuthorWithBooks(1))
	val channel = Channel<String>()
	val bookService = BookService(channel, BookDAO.getAllBooks(),2000)
	val job = launch{
		bookService.generateBooks()
	}
	repeat(5) {
		println(bookService.getRandomBookInfo())
	}
	job.cancelAndJoin()

}