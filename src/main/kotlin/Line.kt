import kotlin.math.hypot

class Line @Throws(IllegalArgumentException::class) constructor(points: List<Point>) : Shape(points) {
    init {
        require((points[0] != points[1])) { "points[0] and points[1] cannot be equal" }
    }

    override val area: Double
        get() = throw UnsupportedOperationException("Lines do not have an area")
    override fun clone(): Line = Line(pointList.map { it.clone() })

    var length: Double = 0.0
        get() = hypot(pointList[1].x - pointList[0].x, pointList[1].y - pointList[0].y)
        private set

    var slope: Double = 0.0
        get() {
            require(pointList[0].x != pointList[1].x) { "Cannot calculate slope for a vertical line" }
            return (pointList[1].y - pointList[0].y) / (pointList[1].x - pointList[0].x)
        }
        private set
}