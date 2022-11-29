package beginner.h_DivideAndConquer


private fun solve(arr: Array<IntArray>, row: Int, col: Int, size: Int) {
    fun check_arr(): Boolean {
        for (i in row until row + size) {
            val tmp = arr[row][col]

            for (j in col until col + size)
                if (arr[i][j] != tmp)
                    return false
        }

        return true
    }

    if (check_arr()) {
        print("${arr[row][col]}")
        return
    }

    val tmp = size / 2;

    print("(")
    solve(arr, row, col, tmp)
    solve(arr, row, col + tmp, tmp)
    solve(arr, row + tmp, col, tmp)
    solve(arr, row + tmp, col + tmp, tmp)
    print(")")
}

fun boj_1992() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val arr = Array(n){ intArrayOf() }
        .map { readLine().map { it.digitToInt() }.toIntArray() }
        .toTypedArray()

    solve(arr, 0, 0, n)
}

