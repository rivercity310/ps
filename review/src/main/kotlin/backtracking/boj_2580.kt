package backtracking

import java.util.StringTokenizer
import kotlin.system.exitProcess

/**
 * 스도쿠 https://www.acmicpc.net/problem/2580
 */

private const val N = 9
private val puzzle = Array(N) { IntArray(N) }
private val points = ArrayList<Pair<Int, Int>>()

private fun check(row: Int, col: Int, num: Int): Boolean {
    // 열 검사
    for (c in 0 until N)
        if (puzzle[row][c] == num)
            return false

    // 행 검사
    for (r in 0 until N)
        if (puzzle[r][col] == num)
            return false

    // 3 by 3 검사
    val tx = (row / 3) * 3
    val ty = (col / 3) * 3

    for (r in tx until tx + 3)
        for (c in ty until ty + 3)
            if (puzzle[r][c] == num)
                return false

    return true
}

private fun solve(n: Int) {
    if (n == points.size) {
        val sb = StringBuffer()

        for (i in 0 until N) {
            for (j in 0 until N)
                sb.append(puzzle[i][j]).append(' ')
            sb.append('\n')
        }

        print(sb)
        exitProcess(0)
    }

    for (i in 1..N) {
        val (x, y) = points[n]

        if (!check(x, y, i)) continue
        puzzle[x][y] = i
        solve(n + 1)
        puzzle[x][y] = 0
    }
}

fun boj_2580() = with(System.`in`.bufferedReader()) {
    for (i in 0 until N) {
        val st = StringTokenizer(readLine())

        for (j in 0 until N) {
            val p = st.nextToken().toInt()
            if (p == 0) points += Pair(i, j)
            puzzle[i][j] = p
        }
    }

    solve(0)
}