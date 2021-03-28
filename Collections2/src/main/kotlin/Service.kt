class Service {

	companion object {

		fun getBookWithReviews(): List<BookWithReviews> {
			return SourceOfBooks.getAll().map {
				val reviews = SourceOfReviews.getBookReview(it.id)
				BookWithReviews(it.id, it.name, it.author, it.year, reviews?.rating, reviews?.reviewsId)
			}
		}

		fun sortByRating(): List<BookWithReviews> = getBookWithReviews().sortedBy { it.rating }.reversed()

		fun groupByAuthor(): Map<String, List<BookWithReviews>> = getBookWithReviews().groupBy { it.author }

		fun getQuantity(predicate: (BookWithReviews) -> Boolean): Int = getBookWithReviews().count(predicate)

	}
}