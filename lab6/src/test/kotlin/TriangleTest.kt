import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TriangleTest {

	private val triangle = Triangle(45.0, 45.0)

	@Test
	fun `Comparing right triangle with right triangle`() {
		val result = triangle.compareWithTriangleType(TriangleType.RIGHT)
		assertEquals(true, result)
	}

	@Test
	fun `Comparing right triangle with equilateral triangle`() {
		val result = triangle.compareWithTriangleType(TriangleType.EQUILATERAL)
		assertEquals(false, result)
	}

	@Test
	fun `Getting third angle in radians`(){
		val result = triangle.getThirdAngle(Measure.RADIAN)
		assertEquals(1.57, result)
	}

	@Test
	fun `Getting third angle in degrees`(){
		val result = triangle.getThirdAngle(Measure.DEGREE)
		assertEquals(90.0, result)
	}
}