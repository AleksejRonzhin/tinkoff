import Service.Companion.getQuantity

fun main() {
	val books = SourceOfBooks.getAll()
	println("All books:")
	books.forEach() {
		println(it)
	}
	println("Book with id = 3:")
	println(SourceOfBooks.getBook(3))
	val bookReviews = SourceOfReviews.getAll()
	println("All bookReviews:")
	bookReviews.forEach() {
		println(it)
	}
	println("BookReviews with bookId = 2:")
	println(SourceOfReviews.getBookReview(2))
	println("BookWithReviews:")
	val listBook = Service.getBookWithReviews()
	listBook.forEach() {
		println(it)
	}
	println("Sorted by rating:")
	Service.sortByRating(listBook).forEach() {
		println(it)
	}
	println("Grouped by author:")
	Service.groupByAuthor(listBook).forEach {
		println(it)
	}
	print("Number of books published since 2012: ")
	println(listBook.getQuantity { it.year > 2012 })
	print("Number of Pushkin's books: ")
	println(listBook.getQuantity { it.author == "Пушкин" })

}