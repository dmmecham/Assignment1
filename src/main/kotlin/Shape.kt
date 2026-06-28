abstract class Shape(points: List<Point>) {
    protected var pointList = points.map{ it.clone() }
        private set

    val points: List<Point>
        get() = pointList.map{ it.clone()}

    init {
        require(pointList.isNotEmpty()) { "Shape must have at least one point" }
        require(pointList.distinctBy { it.x to it.y }.size == pointList.size) { "Duplicate points found, invalid shape" }
    }

    final fun move(delta: Point) {
        pointList = pointList.map { it.move(delta.x, delta.y) }
    }

    abstract val area: Double
    abstract fun clone(): Shape
}