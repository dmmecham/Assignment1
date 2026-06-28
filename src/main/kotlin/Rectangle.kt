import kotlin.math.abs

open class Rectangle(corners: List<Point>) : Shape(corners) {
    init {
        require(corners.size == 2) { "Rectangle must have two points for opposite corners" }
        require(
            corners[0].x < corners[1].x &&
                    corners[0].y < corners[1].y
        ) {
            "The first corner must have smaller x and y coordinates than the second corner."
        }
    }

    override fun clone(): Rectangle = Rectangle(pointList.map { it.clone() })
    override val area: Double
        get() = width * height

    private val corner1: Point
        get() = pointList[0]
    private val corner2: Point
        get() = pointList[1]
    val height: Double
        get() = abs(corner1.y - corner2.y)
    val width: Double
        get() = abs(corner1.x - corner2.x)

}