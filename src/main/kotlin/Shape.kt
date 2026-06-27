abstract class Shape(protected var pointList: List<Point>) {
    init {
        require(pointList.isNotEmpty()) { "Shape must have at least one point" }
        require(pointList.distinctBy { it.x to it.y }.size == pointList.size) { "Duplicate points found, invalid shape" }
    }

    fun move(point: Point) {
        pointList.forEach { p -> p.move(point) }
    }

    val points: List<Point>
        get() = pointList
    abstract val area: Double
    abstract fun clone(): Shape
}