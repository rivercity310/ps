package boj.intermediate

private lateinit var grp: Array<ArrayList<Int>>
private lateinit var inDegree: IntArray

private fun solve() {
    val q = ArrayDeque<Int>()
    for (i in 1 until inDegree.size) if (inDegree[i] == 0) q.add(i)

    while (q.isNotEmpty()) {
        val now = q.removeFirst()
        print("$now ")

        for (next in grp[now]) {
            inDegree[next]--
            if (inDegree[next] == 0) q.add(next)
        }
    }
}

fun boj_1766() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    grp = Array(n + 1) { ArrayList() }
    inDegree = IntArray(n + 1) { 0 }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        grp[a].add(b)
        inDegree[b]++
    }

    var p = -1
    for (i in 1 until inDegree.size)
        if (inDegree[i] == 0) {
            p = i
            break
        }

    for (i in p + 1 until inDegree.size) {
        if (inDegree[i] == 0) {
            grp[p].add(i)
            inDegree[i]++
        }
    }

    solve()
    close()
}