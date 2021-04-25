package faculties

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
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