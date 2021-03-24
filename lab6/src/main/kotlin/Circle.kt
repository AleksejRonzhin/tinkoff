import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt

class Circle(val id: Int, private val radius: Double, private val x0: Int, private val y0: Int) {
	fun getVolumeCylinderOnCircle(height: Double): Double =
		(this.radius.pow(2) * PI * height * 100).roundToInt() / 100.0

	fun printCircle() {
		println("Circle with radius = ${this.radius} in ($x0,$y0)")
	}
}

fun circle(lambda: Circle.() -> Unit): Circle = Circle(1, 0.0, 0, 0).apply(lambda)