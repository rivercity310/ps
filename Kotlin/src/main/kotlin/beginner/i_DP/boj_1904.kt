package beginner.i_DP

private const val DIV = 15746UL
private lateinit var dp: Array<ULong>

fun boj_1904() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
/*
    dp = Array(n + 1) { 0UL }
    dp[1] = 1UL        // 1
    dp[2] = 2UL        // 00, 11
    dp[3] = 3UL        // 001 100 111  -> 1001 0011 1100 1001 1111
    dp[4] = 5UL        // 0011, 0000, 1001, 1100, 1111 -> (10011) 00111 10000 00001 (11001) 10011 11001 11100 11111
    dp[5] = 8UL        // (00001), 00111, (11111), (10000), 11100, 10011, 11001
*/
    for (i in 6..n) {
        dp[i] = (dp[i - 1] * 2UL - 1UL) - dp[i - 3]
    }

    println(dp[n] % DIV)
}