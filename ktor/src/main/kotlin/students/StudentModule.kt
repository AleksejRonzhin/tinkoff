package students

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import org.kodein.di.ktor.di
import org.kodein.di.singleton

fun Application.studentModule() {

//    val dao: StudentDao by closestDI().instance()
    val service: StudentService by closestDI().instance()

    routing {
        route("/students"){
            get {
                call.respond(service.findAll())
            }
            post {
                val request = call.receive<CreateStudentRequest>()
                call.respond(service.create(request.name, request.facultyId))
            }
        }
    }
}

fun DI.Builder.studentComponents() {
    bind<StudentDao>() with singleton {
        StudentDao(instance())
    }
    bind<StudentService>() with singleton {
        StudentService(instance())
    }
}

@Serializable
public data class CreateStudentRequest(val name: String, val facultyId: Int)
