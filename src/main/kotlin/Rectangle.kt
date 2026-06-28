import kotlin.math.abs

open class Rectangle @Throws(IllegalArgumentException::class) constructor(points: List<Point>) : Shape(points) {
    init {
        require(points.size == 2) { "Rectangle must have two points for upper-left and lower-right corners" }
        require(points[0].x < points[1].x && points[0].y < points[1].y) { "First point should be the upper-left corner" }
        require(width > 0.0) { "Width must be positive" }
        require(height > 0.0) { "Height must be positive" }
    }

    override fun clone(): Rectangle = Rectangle(pointList.map { it.clone() })
    override val area: Double
        get() = width * height

    val height: Double
        get() = abs(pointList[0].y - pointList[1].y)
    val width: Double
        get() = abs(pointList[0].x - pointList[1].x)
}