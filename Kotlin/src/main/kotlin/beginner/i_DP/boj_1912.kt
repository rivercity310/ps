package beginner.i_DP

private lateinit var prefixSum: IntArray
private lateinit var arr: IntArray
private lateinit var dp: IntArray

fun boj_1912() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = readLine()
        .split(" ")
        .map { it.toInt() }
        .toIntArray()

    if (arr.all { it <= 0 }) {
        println(arr.max())
        return@with
    }

    /*
    prefixSum = IntArray(n + 1) { 0 }
    for (i in 1 until prefixSum.size) prefixSum[i] = prefixSum[i - 1] + arr[i - 1]

    var max = 0
    for (i in 1 until prefixSum.size)
        for (j in 0 until i)
            max = maxOf(prefixSum[i] - prefixSum[j], max)

    print(max)
    */

    dp = IntArray(n) { 0 }
    dp[1] = arr.max()
}