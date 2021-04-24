package students

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class StudentDao(private val database: Database) {
    fun findAll(): List<Student> = transaction(database) {
        Students.selectAll().map(::extractStudent)
    }

    fun create(name: String, facultyId: Int): Student = transaction(database){
        val id = Students.insertAndGetId {
            it[Students.name] = name
            it[Students.facultyId] = facultyId
        }
        Student(id.value, name, facultyId)
    }

    fun update(id: Int, name: String, facultyId: Int) = transaction(database){
        Students.update({Students.id eq id}){
            it[Students.name] = name
            it[Students.facultyId] = facultyId
        }
    }

    fun findById(id: Int): Student = transaction(database){
        Students.select {
            Students.id eq id
        }.map(::extractStudent).single()
    }

    fun findByFacultyId(facultyId: Int): List<Student> = transaction(database){
        Students.select {
            Students.facultyId eq facultyId
        }.map(::extractStudent)
    }

    fun moveToFaculties(id: Int, facultyId: Int) = transaction(database) {
        Students.update({Students.id eq id}){
            it[Students.facultyId] = facultyId
        }
    }

    fun delete(id: Int) = transaction(database) {
        Students.deleteWhere {
            Students.id eq id
        }
    }

    private fun extractStudent(row: ResultRow):Student = Student(
        row[Students.id].value,
        row[Students.name],
        row[Students.facultyId]
    )
}