fun main() {
	val client = Client("/SQL/src/main/resources/BookShop.db")
	val service = Service(client)
	client.use {
		try {
			Initialization.createTables(it)
			Initialization.fillTables(it)
			val bookId = 2
			println("Книга с id = $bookId:")
			println(service.getBookById(bookId))
			println("Совершеннолетние покупатели:")
			service.getAdultCustomers().forEach { el ->
				println(el)
			}
			val authorId = 1
			println("Все книги автора с id = $authorId:")
			service.getAllBooksAuthorById(authorId).forEach { el ->
				println(el)
			}
			println("Все книги купленные больше одного раза:")
			service.getBooksBuyingMoreOneTime().forEach { el ->
				println(el)
			}
			println("Авторы 18 века:")
			service.getAuthorBornInEighteenthCenturySortedByBirthYear().forEach { el ->
				println(el)
			}
		} catch (e: MyException) {
			println(e.message)
			if (e.cause != null){
				println(e.cause.message)
			}
		} finally {
			try {
				Initialization.dropTables(client)
				println("Таблицы удалены")
			} catch (e: MyException) {
				println(e.message)
				if (e.cause != null){
					println(e.cause.message)
				}
			}
		}
	}
}
