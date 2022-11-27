package beginner.d_GraphSearch


fun solve(matrix: Array<IntArray>): Int {
    val deque = ArrayDeque<Pair<Int, Int>>()
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    deque.add(Pair(0, 0))

    while (deque.isNotEmpty()) {
        val (x, y) = deque.first()
        deque.removeFirst()

        for (i in 0..3) {
            val tx = x + dx[i]
            val ty = y + dy[i]

            if (tx < 0 || ty < 0 || tx >= matrix.size || ty >= matrix[tx].size)
                continue

            if (matrix[tx][ty] == 1) {
                matrix[tx][ty] = matrix[x][y] + 1
                deque.add(Pair(tx, ty))
            }
        }
    }

    for (a in matrix) {
        for (b in a)
            print("$b ")
        println()
    }

    return matrix[matrix.lastIndex][matrix[0].lastIndex]
}

fun boj_2178() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    // 붙어있는 수 입력받기
    val matrix = Array(n) { IntArray(m) }
        .map { readLine().map { it.digitToInt() }.toIntArray() }
        .toTypedArray()

    print(solve(matrix))
}