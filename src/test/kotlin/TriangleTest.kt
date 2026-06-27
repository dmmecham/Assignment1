import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TriangleTest {
    val triangle = Triangle(listOf(Point(1.0, 1.0), Point(2.0, 1.0), Point(2.0, 2.0)))

    @Test
    @DisplayName("Valid triangle should have an area")
    fun testArea() {
        assertFailsWith<IllegalArgumentException> {
            Triangle(
                listOf(
                    Point(1.0, 1.0),
                    Point(2.0, 1.0),
                    Point(3.0, 1.0)
                )
            )
        }
        assertEquals(triangle.area, 0.5)
    }

    @Test
    @DisplayName("Triangle should move to the correct location")
    fun testMove() {
        val t2 = triangle.clone()
        t2.move(Point(1.0, 1.0))
        assertEquals(2.0, t2.points[0].x)
        assertEquals(2.0, t2.points[0].y)
        assertEquals(3.0, t2.points[1].x)
        assertEquals(2.0, t2.points[1].y)
        assertEquals(3.0, t2.points[2].x)
        assertEquals(3.0, t2.points[2].y)
        // Make sure the original triangle did not change.
        assertEquals(1.0, triangle.points[0].x)
        assertEquals(1.0, triangle.points[0].y)
        assertEquals(2.0, triangle.points[1].x)
        assertEquals(1.0, triangle.points[1].y)
        assertEquals(2.0, triangle.points[2].x)
        assertEquals(2.0, triangle.points[2].y)
    }
}