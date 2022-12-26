package boj.beginner.k_backtracking

import kotlin.math.abs

private lateinit var path: IntArray
private var ans = 0

private fun nQueen(x: Int, y: Int, n: Int) {
    for (i in 0 until y) {
        if (path[i] == x || abs(x - path[i]) == y - i)
            return
    }

    if (y == n - 1) {
        ans++
        return
    }

    for (i in 0 until n) {
        path[y + 1] = i
        nQueen(i, y + 1, n)
    }
}

fun boj_9663() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    path = IntArray(n) { 0 }
    for (i in 0 until n) {
        path[0] = i
        nQueen(i, 0, n)
    }
    println(ans)
}