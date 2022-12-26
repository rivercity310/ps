package boj.beginner.h_DivideAndConquer

private val dp = HashMap<ULong, ULong>()

// fail......

private fun solve(a: ULong, b: ULong, c: ULong): ULong =
    when {
        b == 1UL -> a % c
        dp.containsKey(b) -> dp[b]!!
        b % 2UL == 1UL -> {
            dp[b] = solve(a, b / 2UL, c) * solve(a, b / 2UL, c) * a % c
            dp[b]!!
        }
        else -> {
            dp[b] = solve(a, b / 2UL, c) * solve(a, b / 2UL, c) % c
            dp[b]!!
        }
    }


fun boj_1629_with_dp() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine()
        .split(" ")
        .map { it.toULong() }

    print(solve(a, b, c))
}