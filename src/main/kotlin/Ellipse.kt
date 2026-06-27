import kotlin.math.PI

open class Ellipse @Throws(IllegalArgumentException::class) constructor(
    center: Point,
    val radius1: Double,
    val radius2: Double
) : Shape(listOf(center)) {
    init {
        require(radius1 > 0.0) { "radius1 must be positive" }
        require(radius2 > 0.0) { "radius2 must be positive" }
    }

    override var area: Double = radius1 * radius2 * PI

    override fun clone(): Ellipse = Ellipse(center.clone(), radius1, radius2)
    var center: Point = pointList[0]
        private set
}