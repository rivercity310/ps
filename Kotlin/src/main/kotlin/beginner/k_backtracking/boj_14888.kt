package beginner.k_backtracking

private var n = 0
private var maxVal = Int.MIN_VALUE
private var minVal = Int.MAX_VALUE
private lateinit var nums: IntArray
private lateinit var ops: IntArray

private fun dfs(depth: Int, result: Int) {
    if (depth == n) {
        maxVal = maxOf(maxVal, result)
        minVal = minOf(minVal, result)
        return
    }

    ops.forEachIndexed { i, op ->
        if (op > 0) {
            ops[i]--

            when (i) {
                0 -> dfs(depth + 1, result + nums[depth])
                1 -> dfs(depth + 1, result - nums[depth])
                2 -> dfs(depth + 1, result * nums[depth])
                3 -> dfs(depth + 1, result / nums[depth])
            }

            ops[i]++
        }
    }
}

fun boj_14888() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    nums = readLine().split(" ").map { it.toInt() }.toIntArray()
    ops = readLine().split(" ").map { it.toInt() }.toIntArray()

    dfs(1, nums[0])
    println(maxVal)
    println(minVal)
}