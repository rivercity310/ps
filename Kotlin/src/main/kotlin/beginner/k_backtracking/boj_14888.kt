package beginner.k_backtracking

private val exp = ArrayDeque<Int>()

private fun solve(depth: Int, start: Int, arr: List<Int>, ops: MutableList<Int>) {
    val size = arr.size + ops.size

    if (depth == size) {
        for (e in exp) print("$e ")
        println()
        return
    }

    for (i in start until size) {
        exp.add(arr[i])
        if (ops[i] != 0) exp.add(ops[i])
        solve(depth + 1, i + 1, arr, ops)
        if (ops[i] != 0) {
            exp.removeLast()
            ops[i]--
        }
        exp.removeLast()
    }
}

fun boj_14888() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val ops = readLine().split(" ").map { it.toInt() }.toMutableList()

    solve(0, 0, arr, ops)
}