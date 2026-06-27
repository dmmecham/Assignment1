import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
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
    @DisplayName("Lines should have a non-zero length")
    fun testLength() {
        assertFailsWith<IllegalArgumentException> { Line(listOf(Point(1.0, 1.0), Point(1.0, 1.0))) }
        assertEquals(horizontalLine.length, 1.0)
        assertEquals(slopedLine.length, 5.0)
        assertEquals(verticalLine.length, 1.0)
    }

    @Test
    @DisplayName("Line should move to the correct location")
    fun testMove() {
        val line = slopedLine.clone()
        line.move(Point(1.0, 2.0))
        assertEquals(line.points[0].x, 1.0)
        assertEquals(line.points[0].y, 2.0)
        assertEquals(line.points[1].x, 5.0)
        assertEquals(line.points[1].y, 5.0)
    }

    @Test
    @DisplayName("Line should have a slope when not vertical")
    fun testSlope() {
        assertEquals(horizontalLine.slope, 0.0)
        assertEquals(slopedLine.slope, 0.75)
        assertThrows<IllegalArgumentException> { verticalLine.slope }
    }
}