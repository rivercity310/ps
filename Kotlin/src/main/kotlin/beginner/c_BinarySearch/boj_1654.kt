package beginner.c_BinarySearch

private fun solve(arr: MutableList<Long>, n: Int): Long {
    var left = 1L
    var right = arr[arr.lastIndex]
    var ans = 0L

    while (left <= right) {
        val mid = (left + right) / 2
        var tmp = 0L

        for (a in arr)
            tmp += a / mid

        if (tmp < n) right = mid - 1
        else {
            left = mid + 1
            ans = maxOf(ans, mid)
        }
    }

    return ans
}

fun boj_1654() = with(System.`in`.bufferedReader()) {
    val (k, n) = readLine()
        .split(" ")
        .map { it.toInt() }

    val arr = mutableListOf<Long>()

    repeat(k) {
        arr.add(readLine().toLong())
    }

    arr.sort()

    print(solve(arr, n))
}