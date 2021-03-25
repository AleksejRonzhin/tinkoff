import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CircleDAOTest {

	@MockK
	lateinit var dao: CircleDAO
	var slot = slot<Int>()

	@Test
	fun `Test get circle by id`() {
		val circle = circle {
			this.id = 1
			this.radius = 5.0
			this.x0 = 0
			this.y0 = 0
		}
		dao = mockk {
			every { getCircleById(capture(slot)) } returns circle
		}

		val res = dao.getCircleById(1)
		assertEquals(1, slot.captured)
		assertEquals(circle, res)
		verify { dao.getCircleById(1) }

	}

	@Test
	fun `Test get circle by id more than 5`() {
		dao = mockk {
			every { getCircleById(capture(slot)) } returns null
		}

		val res = dao.getCircleById(6)
		assertEquals(6, slot.captured)
		assertEquals(null, res)
		verify { dao.getCircleById(6) }

	}

	@Test
	fun `get all circles`() {
		val circleList = listOf(
			circle {
				this.id = 1
				this.radius = 5.0
				this.x0 = 0
				this.y0 = 0
			},
			circle {
				this.id = 2
				this.radius = 10.0
				this.x0 = 100
				this.y0 = 100
			}
		)
		dao = mockk {
			every { getAllCircles() } returns circleList
		}
		val res = dao.getAllCircles()

		assertEquals(circleList, res)
		verify { dao.getAllCircles() }
	}

}