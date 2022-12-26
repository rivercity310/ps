package boj.beginner.i_DP

private lateinit var arr: IntArray
private lateinit var dp: IntArray

private fun solve(): Int {
    dp[0] = arr[0]
    dp[1] = dp[0] + arr[1]
    dp[2] = maxOf(dp[1], arr[1] + arr[2], arr[0] + arr[2])
    for (i in 3 until arr.size) dp[i] = maxOf(dp[i - 1], dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])

    return dp[arr.lastIndex]
}

fun boj_2156() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = IntArray(n)

    for (i in arr.indices) arr[i] = readLine().toInt()
    if (n <= 2) {
        println(arr.sum())
        return
    }

    dp = IntArray(n + 1) { 0 }
    println(solve())
}