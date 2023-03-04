package boj.intermediate

import java.lang.StringBuilder

private const val LOG = 18
private var n = 0
private var m = 0
private lateinit var tree: Array<ArrayList<Int>>
private lateinit var parents: Array<IntArray>
private lateinit var depth: IntArray
private lateinit var visited: BooleanArray

private fun lca(a: Int, b: Int): Int {
    var va = a
    var vb = b

    if (depth[va] > depth[vb]) va = vb.also { vb = va }

    for (i in LOG - 1 downTo 0)
        if (depth[vb] - depth[va] >= (1 shl i))
            vb = parents[vb][i]

    if (va == vb) return va

    for (i in LOG - 1 downTo 0) {
        if (parents[va][i] != parents[vb][i]) {
            va = parents[va][i]
            vb = parents[vb][i]
        }
    }

    return parents[va][0]
}

private fun setParents() {
    fun dfs(node: Int, dth: Int) {
        visited[node] = true
        depth[node] = dth

        for (next in tree[node]) {
            if (!visited[next]) {
                parents[next][0] = node
                dfs(next, dth + 1)
            }
        }
    }

    dfs(1, 0)
    for (i in 1 until LOG)
        for (j in 1..n)
            parents[j][i] = parents[parents[j][i - 1]][i - 1]
}

fun boj_11438() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    n = readLine().toInt()
    tree = Array(n + 1) { ArrayList() }
    parents = Array(n + 1) { IntArray(LOG) }
    depth = IntArray(n + 1)
    visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    setParents()
    m = readLine().toInt()

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        sb.append(lca(a, b)).append('\n')
    }

    print(sb)
    close()
}