import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    println(AuthorWithBooksService.getAuthorWithBooks(1))
    val channel = Channel<String>()
    val bookService = BookService(channel, 2000)
    val job = launch {
        bookService.generateBooks()
    }
    repeat(5) {
        println(bookService.getRandomBookInfo())
    }
    job.cancelAndJoin()
}