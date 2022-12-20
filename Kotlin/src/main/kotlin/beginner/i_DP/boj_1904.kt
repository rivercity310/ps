package beginner.i_DP

private lateinit var dp: IntArray
private const val DIV = 15756

fun boj_1904() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = IntArray(n + 1)
    if (n <= 3) {
        print(n)
        return
    }

    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) dp[i] = ((dp[i - 1] % DIV) + (dp[i - 2] % DIV)) % DIV
    print(dp[n])
}