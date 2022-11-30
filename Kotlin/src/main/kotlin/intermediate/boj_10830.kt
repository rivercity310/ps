package intermediate

private const val DIV = 1000UL
private const val MAX = 5
private val Matrix = Array(MAX) { ulongArrayOf() }

private fun matmul(A: Array<ULongArray>, B: Array<ULongArray>, n: ULong): Array<ULongArray> {
    val size = n.toInt()
    val ans = Array(size) { ULongArray(size) { 0UL } }

    for (k in 0 until size)
        for (i in 0 until size)
            for (j in 0 until size)
                ans[k][i] += (A[k][j] * B[j][i]) % DIV

    return ans
}

private fun solve(A: Array<ULongArray>, n: ULong, b: ULong): Array<ULongArray> {
    if (b == 1UL) return A

    val tmp = solve(A, n, b / 2UL)

    if (b % 2UL == 1UL) {
        val tmp2 = matmul(tmp, tmp, n)
        return matmul(tmp2, A, n)
    }

    return matmul(tmp, tmp, n)
}

fun boj_10830() = with(System.`in`.bufferedReader()) {
    val (n, b) = readLine()
        .split(" ")
        .map { it.toULong() }

    val size = n.toInt()

    for (i in 0 until size) {
        val tmp = readLine()
            .split(" ")
            .map { it.toULong() }
            .toULongArray()

        Matrix[i] = tmp
    }

    val ans = solve(Matrix, n, b)

    for (i in 0 until size) {
        for (j in 0 until size)
            print("${ans[i][j] % DIV} ")
        println()
    }
}