package backtracking

import java.lang.StringBuilder
import java.util.StringTokenizer

private var N = 0
private var M = 0
private val arr = ArrayList<Int>()
private val sb = StringBuilder()

private fun solve(depth: Int) {
    if (depth == M) {
        arr.forEach { sb.append(it).append(' ') }
        sb.append('\n')
        return
    }

    for (i in 1..N) {
        if (i in arr) continue

        arr.add(i)
        solve(depth + 1)
        arr.remove(i)
    }
}

fun boj_15649() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    solve(0)
    print(sb)
}