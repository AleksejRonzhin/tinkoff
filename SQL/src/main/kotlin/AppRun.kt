import java.sql.SQLException

fun main() {
	val client = Client("/SQL/src/main/resources/BookShop.db")
	Service.client = client
	client.use {
		try {
			Initialization.createTables(it)
			Initialization.fillTables(it)
			val bookId = 2
			println("Книга с id = $bookId:")
			println(Service.getBookById(bookId))
			println("Совершеннолетние покупатели:")
			Service.getAdultCustomers().forEach { el ->
				println(el)
			}
			val authorId = 1
			println("Все книги автора с id = $authorId:")
			Service.getAllBooksAuthorById(authorId).forEach { el ->
				println(el)
			}
			println("Все книги купленные больше одного раза:")
			Service.getBooksBuyingMoreOneTime().forEach { el ->
				println(el)
			}
			println("Авторы 18 века:")
			Service.getAuthorBornInEighteenthCenturySortedByBirthYear().forEach { el ->
				println(el)
			}
		} catch (e: SQLException) {
			println(e.message)
		} finally {
			try {
				Initialization.dropTables(client)
				println("Таблицы удалены")
			} catch (e: SQLException) {
				println(e.message)
			}
		}
	}
}
