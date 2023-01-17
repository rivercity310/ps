package backtracking

private var n = 0
private var cnt = 0
private lateinit var field: Array<BooleanArray>

private fun colCheck(col: Int): Boolean {
    for (k in 0 until n)
        if (field[k][col])
            return false

    return true
}

private fun diagonalCheck(row: Int, col: Int): Boolean {
    val a = row + col
    val b = row - col

    for (i in 0 until row) {
        for (j in 0 until n) {
            val c = i + j
            val d = i - j

            if (a == c && field[i][j]) return false
            if (b == d && field[i][j]) return false
        }
    }

    return true
}

private fun solve(row: Int) {
    if (row == n) {
        cnt++
        return
    }

    for (col in 0 until n) {
        if (!colCheck(col)) continue
        if (!diagonalCheck(row, col)) continue

        field[row][col] = true
        solve(row + 1)
        field[row][col] = false
    }
}

fun boj_9663() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    field = Array(n) { BooleanArray(n) { false } }

    solve(0)
    print(cnt)
}