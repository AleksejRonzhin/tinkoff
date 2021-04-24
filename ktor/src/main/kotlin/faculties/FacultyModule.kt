package faculties

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.facultyModule(){

    routing{
        route("/faculties"){
            get {
                call.respondText { "Факультеты мои факультеты" }
            }
        }
    }
}