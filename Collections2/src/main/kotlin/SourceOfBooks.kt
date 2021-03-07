class SourceOfBooks {

    companion object {

        private val list: List<Book> = listOf(
            Book(1, "Мертвые души","Гоголь",2010),
            Book(2, "Война и мир","Толстой", 2015)
        )

        fun getAll(): List<Book> {
            return list
        }

        fun getBook(id: Int): Book?{
            var temp: Book? = null
            list.forEach(){
                if(it.id == id){
                    temp = it
                }
            }
            return temp
        }

    }
}