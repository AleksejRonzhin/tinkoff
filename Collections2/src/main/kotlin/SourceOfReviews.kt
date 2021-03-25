class SourceOfReviews {

	companion object {

		private val list: List<BookReviews> = listOf(
			BookReviews(1, 90, listOf(1, 2, 5)),
			BookReviews(2, 70, listOf(3, 8)),
			BookReviews(3, 40, listOf(4, 9)),
			BookReviews(4, 100, listOf(10, 11)),
			BookReviews(5, 85, listOf()),
			BookReviews(6, 71, listOf(6, 12)),
		)

		fun getAll(): List<BookReviews> = list

		fun getBookReview(id: Int): BookReviews? = list.find { it.bookId == id }
	}
}