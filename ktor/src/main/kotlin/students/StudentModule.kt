package students

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.Database

fun Application.studentModule(database: Database) {

    val dao = StudentDao(database)
    val service = StudentService(dao)

    routing {
        route("/students"){
            get {
                call.respond(service.findAll())
            }
        }
    }
}
