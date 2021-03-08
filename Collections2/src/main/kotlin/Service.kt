class Service {

    companion object{

        fun getBookWithReviews(): List<BookWithReviews> {
            return SourceOfBooks.getAll().map {
                val reviews = SourceOfReviews.getBook(it.id)
                BookWithReviews(it.id, it.name, it.author, it.year, reviews?.rating, reviews?.reviewsId)
            }
        }



    }
}