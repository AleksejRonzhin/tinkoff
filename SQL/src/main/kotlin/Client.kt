import java.sql.*

class Client(url : String) {

    val conn = DriverManager.getConnection("jdbc:sqlite:.$url")

    fun executeUpdate(sql: String){
        conn.createStatement().executeUpdate(sql)
    }



    fun close() = conn.close()
}