package students

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import kotlinx.serialization.Serializable
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import org.kodein.di.singleton

fun Application.studentModule() {

    val service: StudentService by closestDI().instance()

    routing {
        route("/students") {
            get {
                call.respond(service.findAll())
            }
            post {
                val request = call.receive<CreateStudentRequest>()
                call.respond(service.create(request.name, request.facultyId))
            }
            route("/{id}") {
                get {
                    val id = call.parameters["id"]!!.toInt()
                    call.respond(service.findById(id))
                }
                put {
                    val id = call.parameters["id"]!!.toInt()
                    val request = call.receive<UpdateStudentRequest>()
                    call.respond(service.update(id, request.name, request.facultyId))
                }
                patch {
                    val id = call.parameters["id"]!!.toInt()
                    val request = call.receive<MoveToFacultyRequest>()
                    call.respond(service.moveToFaculty(id, request.facultyId))
                }
                delete {
                    val id = call.parameters["id"]!!.toInt()
                    call.respond(service.delete(id))
                }
            }
            route("/faculty/{facultyId}") {
                get {
                    call.respond(service.findByFacultyId(call.parameters["facultyId"]!!.toInt()))
                }
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
private data class CreateStudentRequest(val name: String, val facultyId: Int)

@Serializable
private data class UpdateStudentRequest(val name: String, val facultyId: Int)

@Serializable
private data class MoveToFacultyRequest(val facultyId: Int)
