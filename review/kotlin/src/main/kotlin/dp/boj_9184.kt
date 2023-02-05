package dp

private val dp = Array(21) { Array(21) { IntArray(21) } }

private fun w(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0)
        return 1

    if (a > 20 || b > 20 || c > 20) {
        dp[20][20][20] = w(20, 20, 20)
        return dp[20][20][20]
    }

    if (dp[a][b][c] != 0) return dp[a][b][c]

    if (b in (a + 1) until c) {
        dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return dp[a][b][c]
    }

    dp[a][b][c] = w(a - 1, b, c) +
            w(a - 1, b - 1, c) +
            w(a - 1, b, c - 1) -
            w(a - 1, b - 1, c - 1)

    return dp[a][b][c]
}

fun boj_9184() = with(System.`in`.bufferedReader()) {
    val sb = StringBuffer()

    while(true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) {
            print(sb)
            return
        }

        sb.append("w(")
            .append(a).append(", ")
            .append(b).append(", ")
            .append(c).append(") = ")
            .append(w(a, b, c))
            .append('\n')
    }
}