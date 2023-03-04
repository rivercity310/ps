package boj.intermediate

private var n = 0
private var m = 0
private lateinit var tree: Array<ArrayList<Int>>
private lateinit var depth: IntArray
private lateinit var parents: IntArray
private lateinit var visited: BooleanArray

private fun lca(a: Int, b: Int): Int {
    var na = a
    var nb = b

    while (depth[na] != depth[nb]) {
        if (depth[na] > depth[nb]) na = parents[na]
        else nb = parents[nb]
    }

    while (na != nb) {
        na = parents[na]
        nb = parents[nb]
    }

    return na
}

private fun dfs(node: Int, dth: Int) {
    visited[node] = true
    depth[node] = dth

    for (next in tree[node]) {
        if (!visited[next]) {
            parents[next] = node
            dfs(next, dth + 1)
        }
    }
}

fun boj_11437() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    n = readLine().toInt()
    tree = Array(n + 1) { ArrayList() }
    depth = IntArray(n + 1) { 0 }
    parents = IntArray(n + 1) { 0 }
    visited = BooleanArray(n + 1) { false }

    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a] += b
        tree[b] += a
    }

    dfs(1, 0)
    m = readLine().toInt()

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        sb.append(lca(a, b)).append('\n')
    }

    print(sb)
    close()
}