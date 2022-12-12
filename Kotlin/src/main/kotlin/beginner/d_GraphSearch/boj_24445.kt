package beginner.d_GraphSearch

import java.util.*

private fun solve(grp: Array<MutableList<Int>>, start: Int) {
    val deque = ArrayDeque<Int>()
    val visited = Array<Boolean>(grp.size) { false }
    val ans = Array<Int>(grp.size){ 0 }
    var cnt = 1

    deque.add(start)
    visited[start] = true

    while (deque.isNotEmpty()) {
        val now = deque.pollFirst()
        ans[now] = cnt++

        for (next in grp[now]) {
            if (!visited[next]) {
                visited[next] = true
                deque.add(next)
            }
        }
    }

    for (i in 1 until ans.size) println(ans[i])
}


fun boj_24445() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine()
        .split(" ")
        .map { it.toInt() }

    var grp: Array<MutableList<Int>> = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (u, v) = readLine()
            .split(" ")
            .map { it.toInt() }

        grp[u].add(v)
        grp[v].add(u)
    }

    for (g in grp) g.sortDescending()
    solve(grp, r)
}