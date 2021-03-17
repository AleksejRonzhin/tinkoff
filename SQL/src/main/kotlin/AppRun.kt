import java.sql.DriverManager

fun main(){

    val client = Client("/SQL/src/main/resources/BookShop.db")

    //Init.createTables(client)
    //Init.insertInto(client)

    val bookLst = Service.getBooksBuyingMoreOneTime(client, 1)
    bookLst.forEach{
        println(it.toString())
    }

    //Init.dropTable(client)



    client.close()

}
