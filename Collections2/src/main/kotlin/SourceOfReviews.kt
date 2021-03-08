class SourceOfReviews {

    companion object {

        private val list: List<BookReviews> = listOf(
            BookReviews(1, 90, listOf(1,2,5)),
            BookReviews(2, 70, listOf(3,6,8)),
            BookReviews(3, 40, listOf(4,9,12)),
            BookReviews(4, 100, listOf(10,11,13)),
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