import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class SquareTest {
    var upperLeft = Point(1.0, 2.0)
    var length = 2.0
    val square = Square(upperLeft, length)

    @Test
    @DisplayName("Area should equal height * height")
    fun testArea() {
        assertEquals(square.area, 4.0)
    }

    @Test
    @DisplayName("Height should equal length")
    fun testHeight() {
        assertEquals(square.height, length)
    }

    @Test
    @DisplayName("Width should equal length")
    fun testWidth() {
        assertEquals(square.width, length)
    }

    @Test
    @DisplayName("Square should move to the correct location")
    fun testMove() {
        val s2 = square.clone()
        s2.move(Point(1.0, 2.0))
        assertEquals(s2.points[0].x, 2.0)
        assertEquals(s2.points[0].y, 4.0)
        assertEquals(s2.points[1].x, 4.0)
        assertEquals(s2.points[1].y, 6.0)
    }
}