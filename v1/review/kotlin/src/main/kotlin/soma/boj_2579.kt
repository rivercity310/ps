package soma


private lateinit var stairs: LongArray
private lateinit var dp: LongArray

private fun solve(n: Int): Long {
    dp[1] = stairs[1]
    dp[2] = dp[1] + stairs[2]
    dp[3] = maxOf(stairs[1], stairs[2]) + stairs[3]

    for (i in 4..n) {
        dp[i] = maxOf(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i]
    }

    return dp[n]
}

fun boj_2579() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    stairs = LongArray(n + 1) { 0 }
    dp = LongArray(n + 1) { 0 }

    for (i in 1..n) {
        stairs[i] = readLine().toLong()
    }

    when (n) {
        1 -> print(stairs[1])
        2 -> print(stairs[1] + stairs[2])
        else -> print(solve(n))
    }
}