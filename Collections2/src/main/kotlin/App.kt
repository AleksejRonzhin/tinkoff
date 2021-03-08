fun main(){

    val cars = SourceOfBooks.getAll()

    cars.forEach(){
        println(it)
    }
    println(SourceOfBooks.getBook(2))

    val bookReviews = SourceOfReviews.getAll()
    bookReviews.forEach(){
        println(it)
    }
    println(SourceOfReviews.getBook(2))

    Service.getBookWithReviews().forEach(){
        println(it)
    }
}