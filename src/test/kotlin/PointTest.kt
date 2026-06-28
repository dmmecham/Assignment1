import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class Pointest {
    val point = Point(1.0, 2.0)

    @Test
    @DisplayName("Center should move to the correct location")
    fun testMove() {
        val movedPoint = point.move(1.0, 2.0)
        assertEquals(movedPoint.x, 2.0)
        assertEquals(movedPoint.y, 4.0)
    }
}