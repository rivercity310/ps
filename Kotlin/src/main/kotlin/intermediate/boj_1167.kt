package intermediate

private const val MAX = 100001
private val grp = Array<MutableList<Pair<Int, Int>>>(MAX) { mutableListOf() }
private val visited = BooleanArray(MAX) { false }
private var target = -1
private var max_dist = -1

private fun dfs(node: Int, sum: Int) {
    visited[node] = true

    if (max_dist < sum) {
        max_dist = sum
        target = node
    }

    for ((next, weight) in grp[node])
        if (!visited[next]) dfs(next, sum + weight)
}

private fun solve(): Int {
    dfs(1, 0)
    visited.fill(false)
    dfs(target, 0)
    return max_dist
}

fun boj_1167() = with(System.`in`.bufferedReader()) {
    val v = readLine().toInt()

    repeat (v) {
        val tmp = readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        val node = tmp[0]
        var idx = 1

        while (true) {
            if (tmp[idx] == -1) break
            grp[node].add(Pair(tmp[idx], tmp[idx + 1]))
            idx += 2
        }
    }

    print(solve())
}


/*

data class pr(val index: Int, val weight: Int): Comparable<pr> {
    override fun compareTo(other: pr): Int {
        return this.weight - other.weight
    }
}

fun dijk(grp: Array<MutableList<Pair<Int, Int>>>, start: Int): Pair<Int, Int> {
    val pq = PriorityQueue<pr>()
    val distance = IntArray(grp.size){ Int.MAX_VALUE }

    pq.add(pr(0, start))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val (dist, now) = pq.poll()

        if (distance[now] < dist)
            continue

        for ((next, weight) in grp[now]) {
            val cost = distance[now] + weight

            if (distance[next] > cost) {
                distance[next] = cost
                pq.add(pr(cost, next))
            }
        }
    }

    var rst = -1
    var rst_index = -1

    for ((i, k) in distance.withIndex()) {
        if (k == Int.MAX_VALUE) continue

        if (k > rst) {
            rst = k
            rst_index = i
        }
    }

    return Pair(rst, rst_index)
}
 */