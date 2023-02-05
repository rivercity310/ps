package backtracking

import java.util.StringTokenizer

private var n = 0
private var m = 0
private val sb = StringBuffer()
private val arr = ArrayList<Int>()

private fun solve(depth: Int) {
    if (depth == m) {
        arr.forEach { sb.append(it).append(' ') }
        sb.append('\n')
        return
    }

    for (i in 1..n) {
        arr.add(i)
        solve(depth + 1)
        arr.removeLast()
    }
}

fun boj_15651() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    solve(0)
    print(sb)
}