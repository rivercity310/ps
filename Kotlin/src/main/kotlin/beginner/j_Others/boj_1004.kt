package beginner.j_Others

private data class Circle(val x: Int, val y: Int, val r: Int) {
    private fun getDist(tx: Int, ty: Int) = ((x - tx) * (x - tx)) + ((y - ty) * (y - ty))
    fun isIn(tx: Int, ty: Int) = getDist(tx, ty) <= r * r
}

fun boj_1004() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val (x1, y1, x2, y2) = readLine()
            .split(" ")
            .map { it.toInt() }

        val Circles = ArrayList<Circle>()
        val Start = Pair(x1, y1)
        val End = Pair(x2, y2)

        val n = readLine().toInt()

        repeat(n) {
            val (cx, cy, r) = readLine()
                .split(" ")
                .map { it.toInt() }

            Circles.add(Circle(cx, cy, r))
        }

        var cnt = 0
        for (Circle in Circles) {
            val in1 = Circle.isIn(Start.first, Start.second)
            val in2 = Circle.isIn(End.first, End.second)

            // 둘다 원 안 또는 밖에 있으면 0, 하나가 밖에 있다면 1
            if (in1 != in2) cnt++
        }

        println(cnt)
    }
}
