import java.lang.NumberFormatException
import kotlin.math.PI
import kotlin.math.roundToInt

fun String.radiansInDegree(): String {
	if (this.isEmpty()) {
		throw MyException("Строка пустая")
	}
	try {
		return ((this.toFloat() * 180 / PI * 100).roundToInt() / 100.0).toString()
	} catch (e: NumberFormatException) {
		throw MyException("Не удалось перевести строку в число", e)
	}
}