package soma

private lateinit var tree: List<ArrayList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
private var maxDist = 0
private var farNode = 0

private fun dfs(start: Int, sum: Int) {
    visited[start] = true

    if (sum > maxDist) {
        farNode = start
        maxDist = sum
    }

    for ((node, weight) in tree[start]) {
        if (!visited[node]) {
            visited[node] = true
            dfs(node, sum + weight)
        }
    }
}

fun boj_1967() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = List(n + 1) { arrayListOf() }
    visited = BooleanArray(n + 1) { false }

    for (i in 1 until n) {
        val (p, c, w) = readLine().split(' ').map { it.toInt() }
        tree[p].add(Pair(c, w))
        tree[c].add(Pair(p, w))
    }

    dfs(1, 0)
    visited.fill(false)
    dfs(farNode, 0)

    println(maxDist)
}