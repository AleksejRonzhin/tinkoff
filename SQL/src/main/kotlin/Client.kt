import java.sql.*

class Client(url : String) {

    val conn = DriverManager.getConnection("jdbc:sqlite:.$url")

    fun executeUpdate(sql: String){
        this.conn.createStatement().executeUpdate(sql)
    }

    fun executeQuery(sql : String): List <HashMap<String, Any>> {

        val resList = mutableListOf<HashMap<String, Any>>()

        val preparedStatement = this.conn.prepareStatement(sql)

        val res  = preparedStatement.executeQuery()

        val meta = preparedStatement.metaData

        while(res.next()) {
            val map = hashMapOf<String, Any>()
            var attributeName: String
            var i = 1
            while (i <= meta.columnCount){
                attributeName = meta.getColumnName(i)
                map[attributeName] = res.getObject(i)
                i++
            }
            resList.add(map)
        }

        return resList
    }


    fun close() = this.conn.close()
}