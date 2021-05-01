import DAO.BookDAO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import models.Book
import java.lang.Math.random

class BookService(
    private val channel: Channel<String>,
    private val delay: Long,
    private val bookList: List<Book> = BookDAO.getAllBooks()
) {

    suspend fun generateBooks() {
        while (true) {
            val numberBook = (random() * bookList.size).toInt()
            channel.send(bookList[numberBook].toString())
            delay(delay)
        }
    }

    suspend fun getRandomBookInfo(): String {
        return channel.receive()
    }
}