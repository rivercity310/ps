package beginner.j_Others


private val tmp1 = intArrayOf(1, 0, 1, 0, 1, 0, 1, 0)
private val tmp2 = intArrayOf(0, 1, 0, 1, 0, 1, 0, 1)

private fun black_cnt(arr: Array<CharArray>, row: Int, col: Int): Int {
    var cnt = 0

    for (i in 0 until 8) {
        for (j in 0 until 8) {
            val k = if (arr[i + row][j + col] == 'B') 0 else 1

            // 홀수행
            if (i % 2 == 0) {
                if (tmp2[j] != k) cnt++
            }

            else {
                if (tmp1[j] != k) cnt++
            }
        }
    }

    return cnt
}

private fun white_cnt(arr: Array<CharArray>, row: Int, col: Int): Int {
    var cnt = 0

    for (i in 0 until 8) {
        for (j in 0 until 8) {
            val k = if (arr[i + row][j + col] == 'B') 0 else 1

            // 홀수행
            if (i % 2 == 0) {
                if (tmp1[j] != k) cnt++
            }

            else {
                if (tmp2[j] != k) cnt++
            }
        }
    }

    return cnt
}

private fun solve(arr: Array<CharArray>, row: Int, col: Int): Int {
    return minOf(black_cnt(arr, row, col), white_cnt(arr, row, col))
}

fun boj_1018() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val arr = Array(n) { charArrayOf() }
        .map { readLine().map { it }.toCharArray() }
        .toTypedArray()

    var k = Int.MAX_VALUE
    for (i in 0..(n - 8)) {
        for (j in 0..(m - 8)) {
            k = minOf(k, solve(arr, i, j))
        }
    }

    print(k)
}