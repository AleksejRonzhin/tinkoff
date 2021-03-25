class Service {

	companion object {

		fun getBookWithReviews(): List<BookWithReviews> {
			return SourceOfBooks.getAll().map {
				val reviews = SourceOfReviews.getBookReview(it.id)
				BookWithReviews(it.id, it.name, it.author, it.year, reviews?.rating, reviews?.reviewsId)
			}
		}

		fun sortByRating(list: List<BookWithReviews>): List<BookWithReviews> = list.sortedBy { it.rating }.reversed()


		fun groupByAuthor(list: List<BookWithReviews>): Map<String, List<BookWithReviews>> = list.groupBy { it.author }


		fun List<BookWithReviews>.getQuantity(predicate: (BookWithReviews) -> Boolean): Int = this.count(predicate)

	}
}