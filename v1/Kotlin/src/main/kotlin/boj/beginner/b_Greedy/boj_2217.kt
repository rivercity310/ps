package boj.beginner.b_Greedy

private var n = 0
private lateinit var weights: IntArray

private fun solve(): Int {
    var w = 0
    var idx = 1
    // 로프 1개 -> weights[i]
    // 로프 2개 -> weights[i - 1] * 2
    // 로프 3개 -> weights[i - 2] * 3

    for (i in weights.indices) {
        w = maxOf(w, weights[i] * idx++)
    }

    return w
}

fun boj_2217() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    weights = IntArray(n)
    for (i in weights.indices) weights[i] = readLine().toInt()
    weights.sortDescending()
    print(solve())
}