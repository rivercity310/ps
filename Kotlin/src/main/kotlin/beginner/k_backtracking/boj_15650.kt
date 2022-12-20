package beginner.k_backtracking

private val tmp = ArrayDeque<Int>()

private fun dfs(depth: Int, start: Int, n: Int, m: Int) {
    if (depth == m) {
        for (v in tmp) print("$v ")
        println()
        return
    }

    for (i in start..n) {
        if (i !in tmp) {
            tmp.add(i)
            dfs(depth + 1, i + 1, n, m)
            tmp.removeLast()
        }
    }
}

fun boj_15650() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    dfs(0, 1, n, m)
}