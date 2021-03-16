import java.sql.DriverManager

fun main(){

    val client = Client("/SQL/src/main/resources/BookShop.db")

    Init.createTables(client)
    Init.insertInto(client)
    Init.dropTable(client)

    client.close()

}
