import kotlinx.coroutines.*

fun main() = runBlocking{
	println(AuthorWithBooksService.getAuthorWithBooks(3))
}