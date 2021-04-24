package students

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class StudentDao(private val database: Database) {
    fun findAll(): List<Student> = transaction(database) {
        Students.selectAll().map(::extractStudent)
    }

    private fun extractStudent(row: ResultRow):Student = Student(
        row[Students.id].value,
        row[Students.name],
        row[Students.facultyId]
    )
}