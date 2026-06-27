data class Point(var x: Double, var y: Double) {
    fun clone(): Point = copy()
    fun moveX(deltaX: Double) {
        x += deltaX
    }

    fun moveY(deltaY: Double) {
        y += deltaY
    }

    fun move(deltaX: Double, deltaY: Double) {
        moveX(deltaX); moveY(deltaY)
    }

    fun move(delta: Point) {
        move(delta.x, delta.y)
    }
}