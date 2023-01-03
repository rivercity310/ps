package boj.beginner.i_DP

private const val DIV = 9901
private lateinit var dp: Array<IntArray>

fun boj_1309() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = Array(n + 1) { IntArray(2) }

    dp[0][0] = 1
    dp[0][1] = 1

    for (i in 2 .. n) {
        for (j in 0 until 2) {
            dp[i][j] = maxOf(dp[i - 1][j], dp[i - 2][j] + dp[i - 1][j])
        }
    }

    println((dp[n].max() * 2 + 1) % DIV)
}

// 0: 2nC0 = 1
// 1: 2nC1 = 2n
// 2: 2nC2 + (4 * (2n - 2) + (2n - 3) * (2n - 4))
