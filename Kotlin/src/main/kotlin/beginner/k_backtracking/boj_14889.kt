package beginner.k_backtracking

import kotlin.math.abs

private var n = 0
private var dist = Int.MAX_VALUE
private lateinit var team: BooleanArray
private lateinit var arr: Array<IntArray>

private fun dfs(idx: Int, depth: Int) {
    val start = ArrayList<Int>()
    val link = ArrayList<Int>()
    var startScore = 0
    var linkScore = 0
    val size = n / 2

    if (depth == size) {
        for (i in 0 until n) {
            if (team[i]) start.add(i)
            else link.add(i)
        }

        for (i in 0 until size) {
            for (j in 0 until size) {
                startScore += arr[start[i]][start[j]]
                linkScore += arr[link[i]][link[j]]
            }
        }

        dist = minOf(abs(startScore - linkScore), dist)
    }

    for (i in idx until n) {
        if (!team[i]) {
            team[i] = true
            dfs(i, depth + 1)
            team[i] = false
        }
    }
}

fun boj_14889() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    team = BooleanArray(n) { false }

    dfs(0, 0)
    print(dist)
}