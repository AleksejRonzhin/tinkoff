import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NumberFormatException

class ExtensionFunctionTest {

	@Test
	fun `name later`(){
		val result = "1.0".radiansInDegree()
		assertEquals("57.3", result)
	}

	@Test
	fun `later`(){
//		assertThrows<NumberFormatException> {
//			"text".radiansInDegree()
//		}
	}

}