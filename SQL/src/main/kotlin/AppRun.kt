import java.sql.DriverManager

fun main(){

    val client = Client("/SQL/src/main/resources/BookShop.db")

    Init.createTables(client)
    Init.insertInto(client)

    println(Service.getBookById(client, 5))
    Service.getAdultCustomers(client).forEach{
        println(it)
    }
    Service.getAllBooksAuthorById(client, 1).forEach{
        println(it)
    }
    Service.getBooksBuyingMoreOneTime(client).forEach{
        println(it)
    }
    Service.getAuthorBornInEighteenthCenturySortedByBirthYear(client).forEach{
        println(it)
    }

    Init.dropTable(client)



    client.close()

}
