import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import students.studentModule

fun main() {
    val config = ConfigFactory.load().extract<AppConfig>()
    migrate(config.database)
    val database = Database.connect(
        url = config.database.url,
        user = config.database.user,
        password = config.database.password
    )

    val engine = embeddedServer(Netty, port = config.http.port) {
        configureSerialization()
        studentModule(database)
    }

    engine.start(wait = true)
}

fun migrate(database: DatabaseConfig) {
    Flyway
        .configure()
        .dataSource(database.url, database.user,database.password)
        .load()
        .migrate()
}
