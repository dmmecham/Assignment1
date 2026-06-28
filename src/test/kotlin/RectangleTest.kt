import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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
    @DisplayName("Height should be difference of y values of points")
    fun testHeight() {
        assertEquals(rectangle.height, 2.0)
        assertFailsWith<IllegalArgumentException> {
            Rectangle(
                listOf(
                    Point(1.0, 1.0),
                    Point(2.0, 1.0),
                )
            )
        }
    }

    @Test
    @DisplayName("Width should be difference of x values of points")
    fun testWidth() {
        assertEquals(rectangle.width, 1.0)
        assertFailsWith<IllegalArgumentException> {
            Rectangle(
                listOf(
                    Point(1.0, 1.0),
                    Point(1.0, 2.0),
                )
            )
        }
    }

    @Test
    @DisplayName("Rectangle must have only two sides")
    fun testSides() {
        assertEquals(rectangle.points.size, 2)
        assertFailsWith<IllegalArgumentException> {
            Rectangle(
                listOf()
            )
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(
                listOf(
                    Point(1.0, 1.0),
                )
            )
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(
                listOf(
                    Point(1.0, 1.0),
                    Point(1.0, 1.1),
                    Point(2.0, 2.0)
                )
            )
        }

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