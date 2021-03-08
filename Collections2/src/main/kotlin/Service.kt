class Service {

    companion object{

        fun getBookWithReviews(): List<BookWithReviews> {
            return SourceOfBooks.getAll().map {
                val reviews = SourceOfReviews.getBook(it.id)
                BookWithReviews(it.id, it.name, it.author, it.year, reviews?.rating, reviews?.reviewsId)
            }
        }

        fun List<BookWithReviews>.sortByRating(): List<BookWithReviews>{
            return this.sortedBy { it.rating }.reversed()
        }

        fun List<BookWithReviews>.groupByAuthor(): Map<String, List<BookWithReviews>>{
            return this.groupBy { it.author }
        }

    }
}