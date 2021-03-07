class SourceOfReviews {

    companion object {

        private val list: List<BookReviews> = listOf(
            BookReviews(1, 100, listOf(1,2,5)),
            BookReviews(2, 70, listOf(3,6,8))
        )

        fun getAll(): List<BookReviews> {
            return list
        }

        fun getBook(id: Int): BookReviews?{
            var temp: BookReviews? = null
            list.forEach(){
                if(it.bookId == id){
                    temp = it
                }
            }
            return temp
        }

    }
}