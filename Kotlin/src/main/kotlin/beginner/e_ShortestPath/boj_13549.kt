package beginner.e_ShortestPath

var ans = -1

fun solve(grp: Array<IntArray>, n: Int, k: Int) {
    val dq = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(grp.size) { false }

    dq.add(Pair(n, 0))
    visited[n] = true

    while (dq.isNotEmpty()) {
        val (now, sec) = dq.removeFirst()

        if (now == k) {
            ans = sec
            return
        }

        if (now * 2 < grp.size && !visited[now * 2]) {
            visited[now * 2] = true
            dq.add(Pair(now * 2, sec))
        }

        if (now - 1 >= 0 && !visited[now - 1]) {
            visited[now - 1] = true
            dq.add(Pair(now - 1, sec + 1))
        }

        if (now + 1 < grp.size && !visited[now + 1]) {
            visited[now + 1] = true
            dq.add(Pair(now + 1, sec + 1))
        }
    }
}

fun boj_13549() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    if (n == k) {
        print("0")
        return
    }

    val m = maxOf(n, k)
    val grp = Array(m * 2 + 1){ intArrayOf() }

    grp[0] = intArrayOf(1)
    grp[1] = intArrayOf(0, 2)

    for (i in 2..m)
        grp[i] = intArrayOf(i - 1, i + 1, i * 2)

    solve(grp, n, k)
    print(ans)
}