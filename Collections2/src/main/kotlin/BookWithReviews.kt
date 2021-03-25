data class BookWithReviews(
	val id: Int,
	val name: String,
	val author: String,
	val year: Int,
	val rating: Int?,
	val reviewsId: List<Int>?
)