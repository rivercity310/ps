package boj.beginner.i_DP

private lateinit var arr: IntArray
private lateinit var dp: IntArray

fun boj_1912() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = readLine()
        .split(" ")
        .map { it.toInt() }
        .toIntArray()

    dp = IntArray(n)
    dp[0] = arr[0]

    for (i in 1 until n) {
        dp[i] = maxOf(dp[i - 1] + arr[i], arr[i])
    }

    print(dp.max())
}