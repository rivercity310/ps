package intermediate

import kotlin.collections.HashMap

private const val DIV = 1000UL
private const val MAX = 5
private val Matrix = Array(MAX) { ulongArrayOf() }
private val dp = HashMap<ULong, Array<ULongArray>>()

private fun matmul(A: Array<ULongArray>, B: Array<ULongArray>, n: ULong): Array<ULongArray> {
    val size = n.toInt()
    val ans = Array(size) { ULongArray(size) { 0UL } }

    for (k in 0 until size)
        for (i in 0 until size)
            for (j in 0 until size)
                ans[k][i] += (A[k][j] * B[j][i]) % DIV

    return ans
}

private fun solve(A: Array<ULongArray>, n: ULong, times: ULong): Array<ULongArray>? {
    if (times == 1UL) return A
    if (dp.containsKey(times)) return dp.get(times)!!
    if (times % 2UL == 0UL) {
        dp.put(times, matmul(solve(A, n, times / 2UL)!!, solve(A, n, times / 2UL)!!, n))
        return dp[times]
    }

    dp.put(times, matmul(A, solve(A, n, times - 1UL)!!, n))
    return dp[times]
}


fun boj_10830_2() = with(System.`in`.bufferedReader()) {
    val (n, b) = readLine()
        .split(" ")
        .map { it.toULong() }

    val size = n.toInt()

    for (i in 0 until size) {
        val tmp = readLine()
            .split(" ")
            .map { it.toULong() }
            .toULongArray()

        Matrix[i] = tmp
    }

    val ans = solve(Matrix, n, b)!!

    for (i in 0 until size) {
        for (j in 0 until size)
            print("${ans[i][j] % DIV} ")
        println()
    }
}