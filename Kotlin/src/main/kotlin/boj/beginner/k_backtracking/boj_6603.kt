package boj.beginner.k_backtracking

private val sb = StringBuilder()
private val deq = ArrayDeque<Int>()
private lateinit var nums: IntArray

private fun solve(depth: Int, start: Int, k: Int) {
    if (depth == 6) {
        deq.forEach { sb.append(it).append(' ') }
        sb.append('\n')
        return
    }

    for (i in start until k) {
        deq += nums[i]
        solve(depth + 1, i + 1, k)
        deq -= nums[i]
    }
}

fun boj_6603() = with(System.`in`.bufferedReader()) {
    while (true) {
        val args = readLine().split(" ").map { it.toInt() }
        val k = args[0]

        if (k == 0) break

        nums = args.slice(1 until args.size).toIntArray()
        solve(0, 0, k)
        sb.append('\n')
    }

    print(sb)
}