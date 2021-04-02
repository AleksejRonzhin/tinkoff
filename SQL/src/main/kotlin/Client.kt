import java.io.Closeable
import java.sql.*

class Client(url: String) : Closeable {

	private val conn: Connection = DriverManager.getConnection("jdbc:sqlite:.$url")

	fun executeUpdate(sql: String) {
		val cs = this.conn.createStatement()
		cs.executeUpdate(sql)
		cs.close()
	}

	fun <T> executeQuery(sql: String, vararg args: String, lambda: (HashMap<String, Any>) -> T): List<T> {
		val resList = mutableListOf<HashMap<String, Any>>()
		val preparedStatement = this.conn.prepareStatement(sql)
		args.forEachIndexed { index, el -> preparedStatement.setString(index + 1, el) }
		val res = preparedStatement.executeQuery()
		val meta = preparedStatement.metaData
		while (res.next()) {
			val map = hashMapOf<String, Any>()
			var i = 1
			while (i <= meta.columnCount) {
				map[meta.getColumnName(i)] = res.getObject(i++)
			}
			resList.add(map)
		}
		if (resList.isEmpty()) {
			throw SQLException("В результате запроса нет ни одного элемента")
		}
		preparedStatement.close()
		res.close()
		return resList.map { lambda(it) }
	}

	override fun close() {
		conn.close()
	}
}
