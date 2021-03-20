import java.sql.*

class Client(url: String) {

	private val conn: Connection = DriverManager.getConnection("jdbc:sqlite:.$url")

	fun executeUpdate(sql: String) {
		this.conn.createStatement().executeUpdate(sql)
	}

	fun executeQuery(sql: String, vararg args: String): List<HashMap<String, Any>> {
		val resList = mutableListOf<HashMap<String, Any>>()
		val preparedStatement = this.conn.prepareStatement(sql)
		args.forEachIndexed { index, el -> preparedStatement.setString(index + 1, el) }
		val res = preparedStatement.executeQuery()
		val meta = preparedStatement.metaData
		while (res.next()) {
			val map = hashMapOf<String, Any>()
			var attributeName: String
			var i = 1
			while (i <= meta.columnCount) {
				attributeName = meta.getColumnName(i)
				map[attributeName] = res.getObject(i)
				i++
			}
			resList.add(map)
		}
		if (resList.isEmpty()) {
			throw MyException("В результате запроса нет ни одного элемента")
		}
		return resList
	}

	fun close() = this.conn.close()
}