package models

data class AuthorWithBooks(val id: Int, val name: String, val birthYear: Int, val books: List<Int>?)
