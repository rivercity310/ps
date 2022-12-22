package beginner.k_backtracking

private val arr = ArrayDeque<Int>()

private fun solve(depth: Int, start: Int, n: Int, m: Int) {
    if (depth == m) {
        for (v in arr) print("${v + 1} ")
        println()
        return
    }

    for (i in start - 1 until n) {
        arr.add(i)
        solve(depth + 1, i + 1, n, m)
        arr.removeLast()
    }
}

fun boj_15652() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    solve(0, 1, n, m)
}