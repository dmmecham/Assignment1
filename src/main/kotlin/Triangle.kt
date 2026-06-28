import kotlin.math.abs

class Triangle(points: List<Point>) : Shape(points) {
    init {
        require(points.size == 3) { "Triangle must have 3 points" }
        require(area > 0.0) { "Area must be positive, points should not be in a straight line" }
    }

    private val corner1: Point
        get() = pointList[0]
    private val corner2: Point
        get() = pointList[1]
    private val corner3: Point
        get() = pointList[2]

    override val area: Double
        get() = abs(
            corner1.x * (corner2.y - corner3.y) +
                    corner2.x * (corner3.y - corner1.y) +
                    corner3.x * (corner1.y - corner2.y)
        ) / 2.0

    override fun clone(): Triangle = Triangle(pointList.map { it.clone() })
}