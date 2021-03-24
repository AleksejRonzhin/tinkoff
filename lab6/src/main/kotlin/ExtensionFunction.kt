import kotlin.math.PI
import kotlin.math.roundToInt

fun String.radiansInDegree(): String {
	return ((this.toFloat() * 180 / PI * 100).roundToInt() / 100.0).toString()
}