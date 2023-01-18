package dp

private lateinit var arr: IntArray
private lateinit var dp: IntArray

private fun solve(n: Int): Int {
    if (n == 1) return arr[0]
    if (n == 2) return arr[0] + arr[1]

    dp[0] = arr[0]
    dp[1] = dp[0] + arr[1]
    dp[2] = maxOf(dp[1], dp[0] + arr[2], arr[1] + arr[2])

    for (i in 3 until n) {
        dp[i] = maxOf(
            dp[i - 1],
            dp[i - 2] + arr[i],
            dp[i - 3] + arr[i - 1] + arr[i]
        )
    }

    return dp[n - 1]
}

fun boj_2156() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = IntArray(n)
    dp = IntArray(n)

    for (i in 0 until n) arr[i] = readLine().toInt()
    print(solve(n))
}