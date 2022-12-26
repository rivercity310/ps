package boj.beginner.k_backtracking

private var n = 0
private var ans = 0
private val flagA = BooleanArray(16) { false }
private val flagB = BooleanArray(32) { false }
private val flagC = BooleanArray(32) { false }

private fun dfs(row: Int) {
    for (col in 0 until n) {
        if (!flagA[col] && !flagB[row + col] && !flagC[row - col + n - 1]) {
            if (row == n - 1) ans++
            else {
                flagA[col] = true
                flagB[row + col] = true
                flagC[row - col + n - 1] = true

                dfs(row + 1)

                flagA[col] = false
                flagB[row + col] = false
                flagC[row - col + n - 1] = false
            }
        }
    }
}

fun boj_9663_2() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    dfs(0)
    print(ans)
}