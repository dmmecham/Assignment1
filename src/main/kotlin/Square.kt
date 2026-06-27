class Square constructor(val point: Point, length: Double) :
    Rectangle(listOf(point, Point(point.x + length, point.y + length))) {
    init {
        require(length > 0) { "Length must be positive: $length" }
    }
}