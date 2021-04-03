import java.sql.SQLException
import classes.*

class Service(private var client: Client) {

	fun getBookById(id: Int): Book {
		try {
			val sql = """
	                SELECT *
	                    FROM Book
	                    WHERE id = ?
	            """.trimIndent()
			return client.executeQuery(sql, id.toString()) {
				Book(
					it["id"] as Int,
					it["name"] as String,
					it["publishYear"] as Int
				)
			}.first()
		} catch (e: SQLException) {
			throw SQLException("Не удалось выполнить запрос на получение книги по id")
		}
	}

	fun getAdultCustomers(): List<Customer> {
		val sql = """
                SELECT *
                    FROM Customer
                    WHERE age >= 18
            """.trimIndent()
		try {
			return client.executeQuery(sql) {
				Customer(it["id"] as Int, it["name"] as String, it["age"] as Int)
			}
		} catch (e: SQLException) {
			throw SQLException("Не удалось выполнить запрос на получение совершеннолетних покупателей")
		}
	}

	fun getAllBooksAuthorById(id: Int): List<Book> {
		val sql = """
                SELECT Book.id, Book.name, Book.publishYear
                    FROM (Author JOIN BookAuthor on Author.id = BookAuthor.authorId)
                        JOIN Book on BookAuthor.bookId = Book.id
                    WHERE Author.id = ?
            """.trimIndent()
		try {
			return client.executeQuery(sql, id.toString()) {
				Book(
					it["id"] as Int,
					it["name"] as String,
					it["publishYear"] as Int
				)
			}
		} catch (e: SQLException) {
			throw SQLException("Не удалось выполнить запрос на получение книг автора по id")
		}
	}

	fun getBooksBuyingMoreOneTime(): List<Book> {
		val sql = """
                SELECT *
                FROM Book
                WHERE id IN (SELECT bookId
                                FROM BookBuying
                                GROUP BY BookId
                                HAVING Count(BookId) > 1)
            """.trimIndent()
		try {
			return client.executeQuery(sql) {
				Book(
					it["id"] as Int,
					it["name"] as String,
					it["publishYear"] as Int
				)
			}
		} catch (e: SQLException) {
			throw SQLException("Не удалось выполнить запрос на получение книг купленных больше 1 раза")
		}
	}

	fun getAuthorBornInEighteenthCenturySortedByBirthYear(): List<Author> {
		val sql = """
                SELECT *
                    FROM Author
                    WHERE birthYear between 1800 and 1900
                    ORDER BY birthYear DESC

            """.trimIndent()
		try {
			return client.executeQuery(sql) {
				Author(it["id"] as Int, it["name"] as String, it["birthYear"] as Int)
			}
		} catch (e: SQLException) {
			throw SQLException("Не удалось выполнить запрос на получение авторов 18 века")
		}
	}
}

