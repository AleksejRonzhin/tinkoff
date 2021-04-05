import org.junit.jupiter.api.Test
import io.mockk.mockk
import io.mockk.every
import io.mockk.slot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertAll


class CircleTest {

	@Test
	fun `circle test`() {
		val slot1 = slot<Double>()
		val circle = mockk<Circle>() {
			every { id } returns 1
			every { radius } returns 5.0
			every { x0 } returns 0
			every { y0 } returns 0
			every { getVolumeCylinderOnCircle(capture(slot1)) } returns 785.4
		}

		val volume = circle.getVolumeCylinderOnCircle(10.0)

		with(circle) {
			assertAll(
				{ assertEquals(1, id) },
				{ assertEquals(5.0, radius) },
				{ assertEquals(0, x0) },
				{ assertEquals(0, y0) },
				{ assertEquals(1, id) },
				{ assertEquals(10.0, slot1.captured) },
				{ assertEquals(volume, getVolumeCylinderOnCircle(10.0)) },
				)
		}

	}

}