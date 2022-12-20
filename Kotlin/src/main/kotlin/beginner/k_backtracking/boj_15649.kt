package beginner.k_backtracking

private lateinit var nums: IntArray
private lateinit var visited: BooleanArray
private val tmp = ArrayDeque<Int>()

private fun dfs(depth: Int, m: Int) {
    if (depth == m) {
        for (i in 0 until tmp.size) print("${tmp[i] + 1} ")
        println()
        return
    }

    for (i in nums.indices) {
        if (visited[i]) continue
        visited[i] = true
        tmp.add(i)
        dfs(depth + 1, m)
        visited[i] = false
        tmp.removeLast()
    }
}

fun boj_15649() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    nums = IntArray(n) { it + 1 }
    visited = BooleanArray(n) { false }

    dfs(0, m)
}