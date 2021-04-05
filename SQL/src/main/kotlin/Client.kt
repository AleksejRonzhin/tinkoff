import java.io.Closeable
import java.sql.*

class Client(url: String) : Closeable {

	private val conn: Connection = DriverManager.getConnection("jdbc:sqlite:.$url")

	fun executeUpdate(sql: String) {
		val cs = this.conn.createStatement()
		try {
			cs.executeUpdate(sql)
		} finally {
			cs.close()
		}
	}

	fun <T> executeQuery(sql: String, vararg args: String, lambda: (ResultSet?) -> T): List<T> {
		val list = mutableListOf<T>()
		val preparedStatement = this.conn.prepareStatement(sql)
		try {
			args.forEachIndexed { index, el -> preparedStatement.setString(index + 1, el) }
			val res = preparedStatement.executeQuery()
			try {
				while (res.next()) {
					list.add(lambda(res))
				}
				if (list.isEmpty()) {
					throw SQLException("В результате запроса нет ни одного элемента")
				}
			} finally {
				res.close()
			}
		} finally {
			preparedStatement.close()
		}
		return list
	}

	override fun close() {
		conn.close()
	}
}
