class Circle @Throws(IllegalArgumentException::class) constructor(center: Point, val radius: Double) :
    Ellipse(center, radius, radius) {
    init {
        require(radius > 0.0) { "Radius must be positive" }
    }
}