package beginner.i_DP

private const val MAX = 51
private val dp = Array(MAX) { Array(MAX) { IntArray(MAX) { 0 } } }

private fun solve(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) return 1
    if (dp[a][b][c] != 0) return dp[a][b][c]
    if (a > 20 || b > 20 || c > 20) return solve(20, 20, 20)

    if (b in (a + 1) until c) {
        dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c)
        return dp[a][b][c]
    }

    dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1)
    return dp[a][b][c]
}

fun boj_9184() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (a, b, c) = readLine()
            .split(" ")
            .map { it.toInt() }

        if (a == -1 && b == -1 && c == -1)
            return

        println("w($a, $b, $c) = ${solve(a, b, c)}")
    }
}