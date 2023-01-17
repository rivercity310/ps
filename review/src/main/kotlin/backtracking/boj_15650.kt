package backtracking

import java.util.StringTokenizer

private var N = 0
private var M = 0
private val arr = ArrayList<Int>()
private val sb = StringBuffer()

private fun solve(start: Int, depth: Int) {
    if (depth == M) {
        arr.forEach { sb.append(it).append(' ') }
        sb.append('\n')
        return
    }

    for (i in start..N) {
        if (i in arr) continue

        arr.add(i)
        solve(i, depth + 1)
        arr.remove(i)
    }
}

fun boj_15650() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    solve(1, 0)
    print(sb)
}