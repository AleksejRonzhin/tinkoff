import java.sql.*

class Client(url : String) {

    val conn = DriverManager.getConnection("jdbc:sqlite:.$url")

    fun executeUpdate(sql:String){
        this.conn.createStatement().executeUpdate(sql)
    }

    fun executeQuery(sql : String, vararg args : String): List <HashMap<String, Any>> {

        val resList = mutableListOf<HashMap<String, Any>>()

        val preparedStatement = this.conn.prepareStatement(sql)

        //args.forEachIndexed{index, el -> preparedStatement.setString(index+1, el) }
        args.mapIndexed { index: Int, item: String ->
            Pair(index, item)
        }.forEach { pair ->
            preparedStatement.setString(pair.first + 1, pair.second)
        }


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