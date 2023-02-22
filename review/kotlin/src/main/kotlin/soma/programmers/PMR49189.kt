package soma.programmers

class PMR49189 {
    private lateinit var grp: Array<ArrayList<Int>>
    private lateinit var visited: BooleanArray
    private lateinit var distance: IntArray

    fun solution(n: Int, edge: Array<IntArray>): Int {
        grp = Array(n + 1) { arrayListOf() }
        visited = BooleanArray(n + 1) { false }
        distance = IntArray(n + 1) { 0 }

        for (e in edge) {
            val start = e[0]
            val end = e[1]

            grp[start].add(end)
            grp[end].add(start)
        }

        bfs(1, 1)

        distance.sort()

        return distance.filter { it == distance[distance.lastIndex] }
            .size
    }

    fun bfs(node: Int, dist: Int) {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(node, dist))

        while (q.isNotEmpty()) {
            val (n, d) = q.removeFirst()

            for (next in grp[n]) {
                if (next == 1) continue

                if (!visited[next]) {
                    visited[next] = true
                    distance[next] = d
                    q.add(Pair(next, d + 1))
                }
            }
        }
    }

    fun main() {
        val vertex = arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2),
            intArrayOf(2, 4)
        )

        println(solution(6, vertex))
    }
}