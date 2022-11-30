package intermediate

private const val M = 1e6.toInt() + 1
private var prefixSum = ULongArray(M) { 0UL }
private var cnt = ULongArray(M) { 0UL }

/*
fun boj_10986() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toULong() }

    println("n : $n, m : $m")

    var result = 0UL

    for (i in 1..n.toInt()) {
        val x = read().toInt()
        println("x: $x")

        prefixSum[i] = (prefixSum[i - 1] + x) % m
        if (prefixSum[i] == 0UL)
            result++

        cnt[prefixSum[i].toInt()]++
    }

    for (i in 0 until m.toInt())
        result += (cnt[i] * (cnt[i] - 1UL)) / 2UL

    print(result)
}
*/

/* O(n^2) 방식 -> 시간 초과 */
private fun boj_10986_fail() = with(System.`in`.bufferedReader()) {
    val (n: Long, m: Long) = readLine()
        .split(" ")
        .map { it.toLong() }

    val arr = readLine()
        .split(" ")
        .map { it.toLong() }
        .toLongArray()

    var cnt = 0

    for (left in 0 until n) {
        var tmp = 0L

        for (right in left until n) {
            tmp += arr[right.toInt()]
            if (tmp % m == 0L) cnt++
        }
    }

    print(cnt)
}