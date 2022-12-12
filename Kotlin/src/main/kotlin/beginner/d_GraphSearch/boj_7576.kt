package beginner.d_GraphSearch

import java.util.StringTokenizer

private data class Point(val x: Int, val y: Int, val day: Int)

private var ans = 0
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)
private val Pt = ArrayList<Pair<Int, Int>>()
private lateinit var Matrix: Array<IntArray>

private fun check_arr(): Boolean {
    for (mat in Matrix) for (m in mat) if (m == 0) return false
    return true
}

private fun solve() {
    val q = ArrayDeque<Point>()
    for (pr in Pt)
        q.add(Point(pr.first, pr.second, 0))

    while (q.isNotEmpty()) {
        val (nx, ny, nd) = q.removeFirst()
        ans = nd

        for (i in 0 until 4) {
            val tx = nx + dx[i]
            val ty = ny + dy[i]

            if (tx < 0 || ty < 0 || tx >= Matrix.size || ty >= Matrix[nx].size)
                continue

            if (Matrix[tx][ty] == 0) {
                Matrix[tx][ty] = 1
                q.add(Point(tx, ty, nd + 1))
            }
        }
    }
}

fun boj_7576() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine()
        .split(" ")
        .map { it.toInt() }

    Matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())

        for (j in 0 until m) {
            val x = st.nextToken().toInt()
            if (x == 1) Pt.add(Pair(i, j))
            Matrix[i][j] = x
        }
    }

    solve()

    if (check_arr()) print(ans)
    else print(-1)
}