class Square constructor(point: Point, length: Double) :
    Rectangle(listOf(point, Point(point.x + length, point.y + length))) {
    init {
        require(length > 0) { "Length must be positive: $length" }
    }

    override fun clone(): Square =
        Square(points[0].clone(), width)
}