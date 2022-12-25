package beginner.k_backtracking

import java.util.StringTokenizer

private const val MAX = 9
private val arr = Array(MAX) { IntArray(MAX) }
private val v = ArrayList<Pair<Int, Int>>()

private fun chk(row: Int, col: Int, i: Int): Boolean {
    for (k in 0 until MAX)
        if (arr[row][k] == i || arr[k][col] == i) return false

    val vx = (row / 3) * 3
    val vy = (col / 3) * 3

    for (a in vx until vx + 3)
        for (b in vy until vy + 3)
            if (arr[a][b] == i) return false

    return true
}

private fun solve(cur: Int): Boolean {
    if (cur == v.size) return true

    val row = v[cur].first
    val col = v[cur].second

    for (i in 1..MAX) {
        if (chk(row, col, i)) {
            arr[row][col] = i
            if (solve(cur + 1)) return true
            arr[row][col] = 0
        }
    }

    return false
}

fun boj_2580() = with(System.`in`.bufferedReader()) {
    for (i in 0 until MAX) {
        val st = StringTokenizer(readLine())

        for (j in 0 until MAX) {
            arr[i][j] = st.nextToken().toInt()
            if (arr[i][j] == 0) v.add(Pair(i, j))
        }
    }

    solve(0)

    for (i in 0 until MAX) {
        for (j in 0 until MAX)
            print("${arr[i][j]} ")
        println()
    }
}