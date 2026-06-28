import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LineTest {
    val horizontalLine = Line(listOf(Point(1.0, 1.0), Point(2.0, 1.0)))
    val slopedLine = Line(listOf(Point(0.0, 0.0), Point(4.0, 3.0)))
    val verticalLine = Line(listOf(Point(1.0, 1.0), Point(1.0, 2.0)))

    @Test
    @DisplayName("Line should not have an area")
    fun testArea() {
        assertFailsWith<UnsupportedOperationException> { slopedLine.area }
    }

    @Test
    @DisplayName("Clone should create an independent copy")
    fun testClone() {
        val clone = slopedLine.clone()

        assertEquals(slopedLine.length, clone.length)
        assertEquals(slopedLine.slope, clone.slope)

        clone.move(Point(1.0, 1.0))

        assertEquals(0.0, slopedLine.points[0].x)
        assertEquals(0.0, slopedLine.points[0].y)

        assertEquals(1.0, clone.points[0].x)
        assertEquals(1.0, clone.points[0].y)
    }

    @Test
    @DisplayName("Lines should have a non-zero length")
    fun testLength() {
        val ex = assertFailsWith<IllegalArgumentException> {
            Line(listOf(Point(1.0, 1.0), Point(1.0, 1.0)))
        }

        assertEquals("Duplicate points found, invalid shape", ex.message)

        assertEquals(1.0, horizontalLine.length)
        assertEquals(5.0, slopedLine.length)
        assertEquals(1.0, verticalLine.length)
    }

    @Test
    @DisplayName("Line should move to the correct location")
    fun testMove() {
        val line = slopedLine.clone()

        line.move(Point(1.0, 2.0))

        assertEquals(1.0, line.points[0].x)
        assertEquals(2.0, line.points[0].y)
        assertEquals(5.0, line.points[1].x)
        assertEquals(5.0, line.points[1].y)

        // Original should be unchanged
        assertEquals(0.0, slopedLine.points[0].x)
        assertEquals(0.0, slopedLine.points[0].y)
        assertEquals(4.0, slopedLine.points[1].x)
        assertEquals(3.0, slopedLine.points[1].y)
    }

    @Test
    @DisplayName("Vertical lines should not have a slope")
    fun testSlope() {
        assertEquals(0.0, horizontalLine.slope)
        assertEquals(0.75, slopedLine.slope)

        val ex = assertFailsWith<IllegalArgumentException> {
            verticalLine.slope
        }

        assertEquals("Cannot calculate slope for a vertical line", ex.message)
    }
}