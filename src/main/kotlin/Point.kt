data class Point(val x: Double, val y: Double) {
    fun clone(): Point = copy()

    fun move(deltaX: Double, deltaY: Double): Point =
        Point(x + deltaX, y + deltaY)
}