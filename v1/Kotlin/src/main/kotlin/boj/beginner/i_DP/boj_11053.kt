package boj.beginner.i_DP

private lateinit var dp: IntArray

fun boj_11053() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    dp = IntArray(n) { 1 }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (arr[i] < arr[j]) dp[j] = maxOf(dp[j], dp[i] + 1)
        }
    }

    println(dp.max())
}
