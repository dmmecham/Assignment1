import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class EllipseTest {
    val ellipse = Ellipse(Point(1.0, 2.0), 10.0, 5.0)

    @Test
    @DisplayName("Area should be pi * radius1 * radius2")
    fun testArea() {
        assertEquals(ellipse.area, 10.0 * 5.0 * Math.PI)
    }

    @Test
    @DisplayName("Center should move to the correct location")
    fun testMove() {
        ellipse.move(Point(1.0, 2.0))
        assertEquals(ellipse.center.x, 2.0)
        assertEquals(ellipse.center.y, 4.0)
    }
}