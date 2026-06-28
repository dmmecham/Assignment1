class Circle(center: Point, val radius: Double) :
    Ellipse(center, radius, radius) {
    init {
        require(radius > 0.0) { "Radius must be positive" }
    }

    override fun clone() = Circle(center.clone(), radius)
}