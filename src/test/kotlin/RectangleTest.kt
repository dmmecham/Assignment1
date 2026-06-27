import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class RectangleTest {
    var upperLeft = Point(1.0, 2.0)
    var lowerRight = Point(2.0, 4.0)
    val rectangle = Rectangle(mutableListOf(upperLeft, lowerRight))

    @Test
    @DisplayName("Area should equal width * height")
    fun testArea() {
        assertEquals(rectangle.area, 2.0)
    }

    @Test
    @DisplayName("Height should be point[1].y - point[0].y")
    fun testHeight() {
        assertEquals(rectangle.height, 2.0)
    }

    @Test
    @DisplayName("Width should be point[1].x - point[0].x")
    fun testWidth() {
        assertEquals(rectangle.width, 1.0)
    }

    @Test
    @DisplayName("Rectangle should move to the correct location")
    fun testMove() {
        val r2 = rectangle.clone()
        r2.move(Point(1.0, 2.0))
        assertEquals(r2.points[0].x, 2.0)
        assertEquals(r2.points[0].y, 4.0)
        assertEquals(r2.points[1].x, 3.0)
        assertEquals(r2.points[1].y, 6.0)
    }
}