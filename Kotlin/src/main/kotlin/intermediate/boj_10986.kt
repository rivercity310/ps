package intermediate

import java.util.*

fun boj_10986() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val preSum = LongArray(n + 1) { 0 }
    val cnt = LongArray(m) { 0 }
    val st = StringTokenizer(readLine())

    for (i in 1 until preSum.size) {
        preSum[i] = preSum[i - 1] + st.nextToken().toLong()
        cnt[(preSum[i] % m).toInt()]++
    }

    var ans = cnt[0]
    for (k in cnt)
        if (k >= 2)
            ans += k * (k - 1) / 2

    println(ans)
}