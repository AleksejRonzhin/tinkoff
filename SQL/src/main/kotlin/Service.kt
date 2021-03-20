import java.sql.SQLException

class Service {

	companion object {

		fun getBookById(client: Client, id: Int): Book {
			val sql = """
                SELECT *
                    FROM Book
                    WHERE id = ?
            """.trimIndent()
			try {
				val result = client.executeQuery(sql, id.toString())
				return Book(result[0]["id"] as Int, result[0]["name"] as String, result[0]["publishYear"] as Int)
			} catch (e: SQLException) {
				throw MyException("Не удалось выполнить запрос на получение книги по id")
			}
		}

		fun getAdultCustomers(client: Client): List<Customer> {
			val sql = """
                SELECT *
                    FROM Customer
                    WHERE age >= 18
            """.trimIndent()
			try {
				val result = client.executeQuery(sql)
				return result.map {
					Customer(it["id"] as Int, it["name"] as String, it["age"] as Int)
				}
			} catch (e: SQLException) {
				throw MyException("Не удалось выполнить запрос на получение совершеннолетних покупателей")
			}
		}

		fun getAllBooksAuthorById(client: Client, id: Int): List<Book> {
			val sql = """
                SELECT Book.id, Book.name, Book.publishYear
                    FROM (Author JOIN BookAuthor on Author.id = BookAuthor.authorId) 
                        JOIN Book on BookAuthor.bookId = Book.id
                    WHERE Author.id = ?
            """.trimIndent()
			try {
				val result = client.executeQuery(sql, id.toString())

				return result.map {
					Book(it["id"] as Int, it["name"] as String, it["publishYear"] as Int)
				}
			} catch (e: SQLException) {
				throw MyException("Не удалось выполнить запрос на получение книг автора по id")
			}
		}

		fun getBooksBuyingMoreOneTime(client: Client): List<Book> {
			val sql = """
                SELECT *
                FROM Book
                WHERE id IN (SELECT bookId
                                FROM BookBuying
                                GROUP BY BookId
                                HAVING Count(BookId) > 1)                    
            """.trimIndent()
			try {
				val result = client.executeQuery(sql)

				return result.map {
					Book(it["id"] as Int, it["name"] as String, it["publishYear"] as Int)
				}
			} catch (e: Exception) {
				throw MyException("Не удалось выполнить запрос на получение книг купленных больше 1 раза")
			}
		}

		fun getAuthorBornInEighteenthCenturySortedByBirthYear(client: Client): List<Author> {
			val sql = """
                SELECT *
                    FROM Author
                    WHERE birthYear between 1800 and 1900
                    ORDER BY birthYear DESC
                    
            """.trimIndent()
			try {
				val result = client.executeQuery(sql)
				return result.map {
					Author(it["id"] as Int, it["name"] as String, it["birthYear"] as Int)
				}
			} catch (e: Exception) {
				throw MyException("Не удалось выполнить запрос на получение авторов 18 века")
			}
		}

	}
}