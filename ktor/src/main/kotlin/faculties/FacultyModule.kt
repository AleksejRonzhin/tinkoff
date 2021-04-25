package faculties

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import org.kodein.di.singleton
import students.StudentDao
import students.StudentService

fun Application.facultyModule(){

    val service: FacultyService by closestDI().instance()

    routing{
        route("/faculties"){
            get {
                call.respond(service.findAll())
            }
            post {
                val request = call.receive<CreateFacultyRequest>()
                call.respond(service.create(request.name))
            }
            route("/{id}"){
                get{
                    val id = call.parameters["id"]!!.toInt()
                    call.respond(service.findById(id))
                }
                put{
                    val request = call.receive<UpdateFacultyRequest>()
                    val id = call.parameters["id"]!!.toInt()
                    call.respond(service.update(id, request.name))
                }
                delete{
                    val id = call.parameters["id"]!!.toInt()
                    call.respond(service.delete(id))
                }
            }
        }
    }
}

fun DI.Builder.facultyComponents() {
    bind<FacultyDao>() with singleton {
        FacultyDao(instance())
    }
    bind<FacultyService>() with singleton {
        FacultyService(instance())
    }
}

@Serializable
private data class CreateFacultyRequest(val name: String)

@Serializable
private data class UpdateFacultyRequest(val name: String)