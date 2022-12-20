package beginner.k_backtracking

private val sb = StringBuilder()
private val tmp = ArrayDeque<Int>()

private fun solve(depth: Int, n: Int, m: Int) {
    if (depth == m) {
        tmp.forEach { sb.append(it + 1).append(' ') }
        sb.append("\n")
        return
    }

    for (i in 0 until n) {
        tmp.add(i)
        solve(depth + 1, n, m)
        tmp.removeLast()
    }
}

fun boj_15651() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    solve(0, n, m)
    print(sb)
}