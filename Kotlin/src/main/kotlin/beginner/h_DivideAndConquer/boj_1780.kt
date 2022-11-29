package beginner.h_DivideAndConquer

private val arr = mutableListOf<IntArray>()
private val cnt = intArrayOf(0, 0, 0)

private fun check_arr(row: Int, col: Int, size: Int): Boolean {
    val tmp = arr[row][col]

    for (i in row until row + size)
        for (j in col until col + size)
            if (arr[i][j] != tmp)
                return false

    return true
}

private fun solve(row: Int, col: Int, n: Int) {
    if (check_arr(row, col, n)) {
        cnt[arr[row][col] + 1]++
        return
    }

    val size = n / 3
    val tmp1 = n / 3
    val tmp2 = tmp1 * 2

    solve(row, col, size)
    solve(row, col + tmp1, size)
    solve(row, col + tmp2, size)

    solve(row + tmp1, col, size)
    solve(row + tmp1, col + tmp1, size)
    solve(row + tmp1, col + tmp2, size)

    solve(row + tmp2, col, size)
    solve(row + tmp2, col + tmp1, size)
    solve(row + tmp2, col + tmp2, size)
}

fun boj_1780() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val tmp = readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        arr.add(tmp)
    }

    solve(0, 0, n)

    for (k in cnt)
        println(k)
}