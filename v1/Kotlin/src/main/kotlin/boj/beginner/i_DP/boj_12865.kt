package boj.beginner.i_DP

private var arr = ArrayList<Pair<Int, Int>>()
private lateinit var dp: Array<IntArray>
private lateinit var dp2: IntArray

private fun solve(n: Int, k: Int) {
    for (i in 1 until n + 1) {
        val (w, v) = arr[i - 1]
        for (j in 1 until k + 1) {
            if (w > j) dp[i][j] = dp[i - 1][j]
            else dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - w] + v)
        }
    }
}

private fun solve2(n: Int, k: Int) {
    for (i in 1 until n + 1) {
        val (w, v) = arr[i - 1]
        for (j in k downTo w)
            dp2[j] = maxOf(dp2[j], dp2[j - w] + v)
    }
}

fun boj_12865() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    dp = Array(n + 1) { IntArray(k + 1) { 0 } }
    dp2 = IntArray(k + 1)

    repeat(n) {
        val (w, v) = readLine().split(" ").map { it.toInt() }
        arr.add(Pair(w, v))
    }

    solve2(n, k)
    println(dp2[k])
}

