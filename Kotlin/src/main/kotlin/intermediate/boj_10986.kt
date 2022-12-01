package intermediate

fun boj_10986() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val preSum = LongArray(n + 1) { 0 }
    val cnt = LongArray(m) { 0 }
    val arr = readLine()
        .split(" ")
        .map { it.toLong() }

    for (i in 1 until preSum.size) {
        preSum[i] = (preSum[i - 1] + arr[i - 1])
        cnt[(preSum[i] % m).toInt()]++
    }

    println("[ preSum ]")
    for (k in preSum)
        print("$k ")
    println()

    println("[ cnt ]")
    for (k in cnt)
        print("$k ")
    println()

    var ans = cnt[0]
    for (k in cnt)
        if (k >= 2)
            ans += k * (k - 1) / 2

    println(ans)
}