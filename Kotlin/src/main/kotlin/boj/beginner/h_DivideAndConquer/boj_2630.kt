package boj.beginner.h_DivideAndConquer

private val arr = mutableListOf<IntArray>()
private var blue_cnt = 0
private var white_cnt = 0

private fun check_arr(row: Int, col: Int, n: Int): Boolean {
    val tmp = arr!![row][col]

    for (i in row until row + n) {
        for (j in col until col + n) {
            if (arr!![i][j] != tmp)
                return false
        }
    }

    return true
}

private fun solve(row: Int, col: Int, n: Int) {
    if (check_arr(row, col, n)) {
        if (arr!![row][col] == 1) blue_cnt++
        else white_cnt++
        return
    }

    val size = n / 2

    solve(row, col, size)                          // 왼쪽 위
    solve(row, col + size, size)               // 오른쪽 위
    solve(row + size, col, size)               // 왼쪽 아래
    solve(row + size, col + size, size)    // 오른쪽 아래
}

fun boj_2630() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val tmp = readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        arr!!.add(tmp)
    }

    solve(0, 0, n)

    println(white_cnt)
    println(blue_cnt)
}