package boj.beginner.i_DP

private lateinit var coins: IntArray
private lateinit var dp: IntArray

fun boj_2293() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    coins = IntArray(n)
    dp = IntArray(k + 1) { 0 }
    dp[0] = 1

    for (i in 0 until n) {
        coins[i] = readLine().toInt()
        var idx = 1
        while (coins[i] * idx <= k) dp[coins[i] * idx++]++
    }

    dp.forEach { print("$it ")}
}