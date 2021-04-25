package faculties

import org.jetbrains.exposed.dao.id.IntIdTable

object Faculties : IntIdTable() {
    val name = text("name")
}