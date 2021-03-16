import java.sql.DriverManager

fun main(){

    val client = Client("/SQL/src/main/resources/BookShop.db")

    Init.createTables(client)
    Init.insertInto(client)

    val res = client.executeQuery("""
        SELECT *
            FROM Book
    """.trimIndent())
    println(res[0]["name"])
    println(res[1]["name"])
    println(res[2]["name"])
    println(res[3]["name"])

    Init.dropTable(client)

    client.close()

}
