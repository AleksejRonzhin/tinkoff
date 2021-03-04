data class Book(val id: Int, val name: String, val author: String, val year: Int){

    override fun toString(): String {
        return "$id, $name, $author, $year"
    }
}

