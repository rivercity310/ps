package beginner.e_ShortestPath

import java.util.*


private data class node(val end: Int, val weight: Int): Comparable<node> {
    override fun compareTo(other: node): Int {
        return this.weight - other.weight
    }
}

private fun solve(grp: MutableList<PriorityQueue<node>>, start: Int, end: Int): Int {
    val pq = PriorityQueue<node>()
    val distance = IntArray(grp.size){Int.MAX_VALUE}

    pq.add(node(start, 0))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val (now, dist) = pq.poll()

        if (distance[now] < dist)
            continue

        for ((next, weight) in grp[now]) {
            val cost = distance[now] + weight

            if (distance[next] > cost) {
                distance[next] = cost
                pq.add(node(next, cost))
            }
        }
    }

    return distance[end]
}

fun boj_1916() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    val grp = MutableList(n){ PriorityQueue<node>() }

    repeat(m) {
        val (u, v, w) = readLine()
            .split(" ")
            .map { it.toInt() }

        grp[u - 1].add(node(v - 1, w))
    }

    val (start, end) = readLine()
        .split(" ")
        .map { it.toInt() }

    print(solve(grp, start - 1, end - 1))
}