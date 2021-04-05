import kotlin.math.PI
import kotlin.math.roundToInt

enum class TriangleType(val lambda: (Double, Double) -> Boolean) {
	EQUILATERAL({ firstAngle, secondAngle -> (secondAngle == 60.0) and (firstAngle == 60.0) }),
	RIGHT({ firstAngle, secondAngle -> (firstAngle == 90.0) or (secondAngle == 90.0) or (firstAngle + secondAngle == 90.0) })
}

enum class Measure(val coefficient: Double) {
	DEGREE(1.0),
	RADIAN(PI / 180)
}

class Triangle(
	private val firstAngle: Double,
	private val secondAngle: Double
) {
	fun compareWithTriangleType(t: TriangleType): Boolean = t.lambda(firstAngle, secondAngle)

	fun getThirdAngle(m: Measure): Double = ((180 - firstAngle - secondAngle) * m.coefficient * 100).roundToInt()/100.0
}