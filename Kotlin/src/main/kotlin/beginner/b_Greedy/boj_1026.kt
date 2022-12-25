package beginner.b_Greedy

private var n = 0
private lateinit var A: IntArray
private lateinit var B: IntArray

private fun solve(): Int {
    var s = 0
    for (i in 0 until n) s += A[i] * B[i]
    return s
}

fun boj_1026() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    A = readLine().split(" ").map { it.toInt() }.toIntArray()
    B = readLine().split(" ").map { it.toInt() }.toIntArray()

    A.sort()
    B.sortDescending()

    print(solve())
}