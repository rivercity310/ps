package boj.beginner.i_DP

private const val DIV = 10007
private lateinit var dp: Array<IntArray>

private fun solve(n: Int, k: Int): Int {
    return if (n == 1) 1
    else if (k == 0 || k == n) return 1
    else if (k == 1 || k == n - 1) return n
    else if (dp[n][k] != 0) dp[n][k]
    else {
        dp[n][k] = ((solve(n - 1, k - 1) % DIV) + (solve(n - 1, k) % DIV)) % DIV
        dp[n][k]
    }
}

fun boj_11051() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    dp = Array(n + 1) { IntArray(n + 1) { 0 } }
    print(solve(n, k))
}