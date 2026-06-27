import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class CircleTest {
    val circle = Circle(Point(1.0, 2.0), 10.0)

    @Test
    @DisplayName("Area should be pi * r^2")
    fun testArea() {
        assertEquals(circle.area, (circle.radius * circle.radius) * Math.PI)
    }

    @Test
    @DisplayName("Center should move to the correct location")
    fun testMove() {
        circle.move(Point(1.0, 2.0))
        assertEquals(circle.center.x, 2.0)
        assertEquals(circle.center.y, 4.0)
    }
}