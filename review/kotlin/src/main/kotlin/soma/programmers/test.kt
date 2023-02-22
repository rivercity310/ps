package soma.programmers

class PMR43162 {
    private lateinit var visited: BooleanArray

    private fun solution(n: Int, computers: Array<IntArray>): Int {
        var ans = 0
        visited = BooleanArray(n) { false }

        for (i in 0 until n) {
            if (chk(visited)) {
                break
            }

            if (visited[i]) {
                continue
            }

            dfs(computers, i)
            ans++
        }

        return ans
    }

    private fun chk(v: BooleanArray): Boolean {
        for (a in v) if (a == false) return false
        return true
    }

    private fun dfs(grp: Array<IntArray>, node: Int) {
        visited[node] = true

        for ((idx, nxt) in grp[node].withIndex()) {
            if (nxt == 1 && !visited[idx]) {
                println("$idx 컴퓨터 방문")
                visited[idx] = true
                dfs(grp, idx)
            }
        }
    }

    fun main() {
        val cpts = listOf(
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 1)
            ),
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 1, 1)
            )
        )

        cpts.forEach {
            println(solution(it.size, it))
        }
    }
}