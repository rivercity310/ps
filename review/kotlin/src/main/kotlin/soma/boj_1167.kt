package soma

private lateinit var tree: List<ArrayList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
private var maxDist = 0L
private var farNode = 0

private fun dfs(start: Int, sum: Long) {
    visited[start] = true

    if (sum > maxDist) {
        maxDist = sum
        farNode = start
    }

    for ((node, weight) in tree[start]) {
        if (!visited[node]) {
            visited[node] = true
            dfs(node, sum + weight)
        }
    }
}

fun boj_1167() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = List(n + 1) { arrayListOf() }
    visited = BooleanArray(n + 1) { false }

    repeat(n) {
        val arr = readLine().split(' ').map { it.toInt() }
        var node = 1
        var weight = 2

        if (arr.size != 2) {
            while (arr[node] != -1) {
                tree[arr[0]].add(Pair(arr[node], arr[weight]))
                node += 2
                weight += 2
            }
        }
    }

    dfs(1, 0)
    visited.fill(false)
    dfs(farNode, 0)

    print(maxDist)
}