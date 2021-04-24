package students

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database

fun Application.studentModule(database: Database) {

    val dao = StudentDao(database)
    val service = StudentService(dao)

    routing {
        route("/students"){
            get {
                call.respond(service.findAll())
            }
            post{
                val request = call.receive<CreateStudentRequest>()
                call.respond(service.create(request.name, request.facultyId))
            }
        }
    }
}

@Serializable
public data class CreateStudentRequest(val name: String, val facultyId: Int)
