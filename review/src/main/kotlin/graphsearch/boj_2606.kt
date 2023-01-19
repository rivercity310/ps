package graphsearch

private var cnt = 0
private lateinit var grp: Array<ArrayList<Int>>
private lateinit var visited: BooleanArray

private fun solve(node: Int) {
    visited[node] = true

    for (next in grp[node]) {
        if (!visited[next]) {
            solve(next)
            cnt++
        }
    }
}

fun boj_2606() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    grp = Array(n + 1) { arrayListOf() }
    visited = BooleanArray(n + 1) { false }

    for (i in 0 until m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        grp[a] += b
        grp[b] += a
    }

    solve(1)
    print(cnt)
}