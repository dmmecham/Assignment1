import kotlin.math.abs

class Triangle(points: List<Point>) : Shape(points) {
    init {
        require(points.size == 3) { "Triangle must have 3 points" }
        require(area > 0.0) { "Area must be positive, points should not be in a straight line" }
    }

    override val area: Double
        get() = abs(
            pointList[0].x * (pointList[1].y - pointList[2].y) +
                    pointList[1].x * (pointList[2].y - pointList[0].y) +
                    pointList[2].x * (pointList[0].y - pointList[1].y)
        ) / 2.0

    override fun clone(): Triangle = Triangle(pointList)
}