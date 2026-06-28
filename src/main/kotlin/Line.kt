import kotlin.math.hypot

class Line @Throws(IllegalArgumentException::class) constructor(points: List<Point>) : Shape(points) {
    init {
        require((points[0] != points[1])) { "points[0] and points[1] cannot be equal" }
    }

    override val area: Double
        get() = throw UnsupportedOperationException("Lines do not have an area")
    override fun clone(): Line = Line(pointList.map { it.clone() })

    private val start: Point
        get() = pointList[0]

    private val end: Point
        get() = pointList[1]

    val length: Double
        get() = hypot(end.x - start.x, end.y - start.y)

    val slope: Double
        get() {
            require(start.x != end.x) {
                "Cannot calculate slope for a vertical line"
            }
            return (end.y - start.y) / (end.x - start.x)
        }
}