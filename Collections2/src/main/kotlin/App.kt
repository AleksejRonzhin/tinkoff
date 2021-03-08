import Service.Companion.getQuantity
import Service.Companion.groupByAuthor
import Service.Companion.sortByRating

fun main(){

    val cars = SourceOfBooks.getAll()
    println("All books:")
    cars.forEach(){
        println(it)
    }
    println("Book with id = 2:")
    println(SourceOfBooks.getBook(2))

    val bookReviews = SourceOfReviews.getAll()
    println("All bookReviews:")
    bookReviews.forEach(){
        println(it)
    }
    println("BookReviews with bookId = 2:")
    println(SourceOfReviews.getBook(2))

    println("BookWithReviews:")
    val listBook = Service.getBookWithReviews()
    listBook.forEach(){
        println(it)
    }
    println("Sorted by rating:")
    listBook.sortByRating().forEach(){
        println(it)
    }
    println("Grouped by author:")
    listBook.groupByAuthor().forEach(){
        println(it)
    }
    print("Number of books published since 2012: ")
    println(listBook.getQuantity { it.year>2012 })
    print("Number of Pushkin's books: ")
    println(listBook.getQuantity { it.author == "Пушкин" })

}