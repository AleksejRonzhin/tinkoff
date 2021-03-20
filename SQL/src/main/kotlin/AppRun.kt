fun main() {
	val client = Client("/SQL/src/main/resources/BookShop.db")
	try {
		Init.createTables(client)
		Init.insertInto(client)
		val bookId = 2
		println("Книга с id = $bookId:")
		println(Service.getBookById(client, bookId))
		println("Совершеннолетние покупатели:")
		Service.getAdultCustomers(client).forEach {
			println(it)
		}
		val authorId = 2
		println("Все книги автора с id = $authorId:")
		Service.getAllBooksAuthorById(client, authorId).forEach {
			println(it)
		}
		println("Все книги купленные больше одного раза:")
		Service.getBooksBuyingMoreOneTime(client).forEach {
			println(it)
		}
		println("Авторы 18 века:")
		Service.getAuthorBornInEighteenthCenturySortedByBirthYear(client).forEach {
			println(it)
		}
	} catch (e: MyException) {
		println(e.message)
	} finally {
		try {
			Init.dropTable(client)
			println("Таблицы удалены")
		} catch (e: MyException) {
			println(e.message)
		} finally {
			client.close()
			println("Соединение закрыто")
		}
	}
}
