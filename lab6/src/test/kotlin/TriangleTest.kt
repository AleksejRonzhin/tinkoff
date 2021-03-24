import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TriangleTest {

	private val Triangle = Triangle(45.0, 45.0)

	@Test
	fun `Comparing right triangle with right triangle`() {
		val result = Triangle.compareWithTriangleType(TriangleType.RIGHT)
		assertEquals(true, result)
	}

	@Test
	fun `Comparing right triangle with equilateral triangle`() {
		val result = Triangle.compareWithTriangleType(TriangleType.EQUILATERAL)
		assertEquals(false, result)
	}

	@Test
	fun `Getting third angle in radians`(){
		val result = Triangle.getThirdAngle(Measure.RADIAN)
		assertEquals(1.57, result)
	}

	@Test
	fun `Getting third angle in degrees`(){
		val result = Triangle.getThirdAngle(Measure.DEGREE)
		assertEquals(90.0, result)
	}
}