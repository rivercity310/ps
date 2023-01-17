package backtracking

import java.util.StringTokenizer

private var n = 0
private var m = 0
private val sb = StringBuffer()
private val arr = ArrayList<Int>()

private fun solve(start: Int, depth: Int) {
    if (depth == m) {
        arr.forEach { sb.append(it).append(' ') }
        sb.append('\n')
        return
    }

    for (i in start..n) {
        arr.add(i)
        solve(i, depth + 1)
        arr.removeLast()
    }
}

fun boj_15652() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    solve(1, 0)
    print(sb)
}