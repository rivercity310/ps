package beginner.d_GraphSearch

private val dx = intArrayOf(-1, -1, 1, 1, -2, -2, 2, 2)
private val dy = intArrayOf(-2, 2, -2, 2, -1, 1, -1, 1)

private fun dfs(x1: Int, y1: Int, x2: Int, y2: Int, l: Int): Int {
    if (x1 == x2 && y1 == y2)
        return 0

    val m = Array(l) { IntArray(l) { 0 } }
    val q = ArrayDeque<Pair<Int, Int>>()

    q.add(Pair(x1, y1))

    while (q.isNotEmpty()) {
        val (nx, ny) = q.removeFirst()

        for (i in 0 until 8) {
            val tx = nx + dx[i]
            val ty = ny + dy[i]

            if (tx < 0 || ty < 0 || tx >= l || ty >= l)
                continue

            if (m[tx][ty] == 0) {
                m[tx][ty] = m[nx][ny] + 1
                q.add(Pair(tx, ty))
            }
        }
    }


    return m[x2][y2]
}

fun boj_7562() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val l = readLine().toInt()
        val (x1, y1) = readLine().split(" ").map { it.toInt() }
        val (x2, y2) = readLine().split(" ").map { it.toInt() }

        println(dfs(x1, y1, x2, y2, l))
    }
}