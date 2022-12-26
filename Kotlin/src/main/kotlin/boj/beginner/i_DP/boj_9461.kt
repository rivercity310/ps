package boj.beginner.i_DP

private val dp = ULongArray(101) { 0UL }

private fun solve(n: Int): ULong {
    for (i in 5..n)
        dp[i] = dp[i - 1] + dp[i - 5]

    return dp[n - 1]
}

fun boj_9461() = with(System.`in`.bufferedReader()) {
    dp[0] = 1UL
    dp[1] = 1UL
    dp[2] = 1UL
    dp[3] = 2UL
    dp[4] = 2UL

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        println(solve(n))
    }
}