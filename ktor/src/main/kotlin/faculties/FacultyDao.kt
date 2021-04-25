package faculties

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import students.Student
import students.Students

class FacultyDao(private val database: Database) {

    fun findAll(): List<Faculty> = transaction(database) {
        Faculties.selectAll().map(::extractFaculty)
    }

    fun findById(id: Int): Faculty = transaction(database) {
        Faculties.select{
            Faculties.id eq id
        }.map(::extractFaculty).single()
    }

    fun create(name: String): Faculty = transaction(database){
        val id = Faculties.insertAndGetId {
            it[Faculties.name] = name
        }
        Faculty(id.value, name)
    }

    fun update(id: Int, name: String) = transaction(database){
        Faculties.update({Faculties.id eq id}){
            it[Faculties.name] = name
        }
    }

    fun delete(id: Int) = transaction(database) {
        Faculties.deleteWhere {
            Faculties.id eq id
        }
    }

    private fun extractFaculty(row: ResultRow): Faculty = Faculty(
        row[Faculties.id].value,
        row[Faculties.name]
    )
}