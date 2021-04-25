package students

import org.jetbrains.exposed.dao.id.IntIdTable

object Students : IntIdTable() {
    val name = text("name")
    val facultyId = integer("FACULTYID")
}