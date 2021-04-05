import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt

class Circle(var id: Int, var radius: Double, var x0: Int, var y0: Int) {
	fun getVolumeCylinderOnCircle(height: Double): Double =
		(this.radius.pow(2) * PI * height * 100).roundToInt() / 100.0

	fun printCircle(): String {
		return "Circle with radius = ${this.radius} in ($x0,$y0) printed"
	}
}

fun circle(lambda: Circle.() -> Unit): Circle = Circle(0, 0.0, 0, 0).apply(lambda)