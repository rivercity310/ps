package intermediate

import java.util.PriorityQueue

private fun Dijk(grp: Array<ArrayList<Pair<Int, Int>>>, start: Int, end: Int): Long {
    val pq = PriorityQueue(Comparator<Pair<Int, Int>>{ a, b -> a.first - b.first })
    val distance = LongArray(grp.size) { Long.MAX_VALUE }

    pq.add(Pair(0, start))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val (dist, now) = pq.poll()

        if (distance[now] < dist) continue

        for ((next, weight) in grp[now]) {
            val cost = distance[now] + weight

            if (distance[next] > cost) {
                distance[next] = cost
                pq.add(Pair(cost.toInt(), next))
            }
        }
    }

    return distance[end]
}

fun boj_9370() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m, t) = readLine()
            .split(" ")
            .map { it.toInt() }

        val grp = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
        val lst = ArrayList<Int>()

        val (s, g, h) = readLine()
            .split(" ")
            .map { it.toInt() }

        repeat(m) {
            val (a, b, d) = readLine()
                .split(" ")
                .map { it.toInt() }

            grp[a].add(Pair(b, d))
            grp[b].add(Pair(a, d))
        }

        repeat(t) {
            lst.add(readLine().toInt())
        }

        // 출발지 -> 목적지의 거리 = 출발지 -> (교차로) -> 목적지의 거리가 같은 목적지
        val ans = ArrayList<Int>()

        for (end in lst) {
            val dist = Dijk(grp, s, end)
            val comp = Dijk(grp, s, g) + Dijk(grp, g, h) + Dijk(grp, h, end)
            val comp2 = Dijk(grp, s, h) + Dijk(grp, h, g) + Dijk(grp, g, end)
            if (dist == minOf(comp, comp2)) ans.add(end)
        }

        ans.sort()
        for (a in ans) print("$a ")
        println()
    }
}