import Service.Companion.getQuantity
import Service.Companion.groupByAuthor
import Service.Companion.sortByRating

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
    println()
    val listBook = Service.getBookWithReviews()
    listBook.forEach(){
        println(it)
    }
    println()
    listBook.sortByRating().forEach(){
        println(it)
    }
    println()
    listBook.groupByAuthor().forEach(){
        println(it)
    }
    println()
    println(listBook.getQuantity { it.year>2012 })

}