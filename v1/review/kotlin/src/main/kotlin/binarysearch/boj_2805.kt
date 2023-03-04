package binarysearch

private lateinit var arr: LongArray

private fun solve(m: Long): Long {
    var left: Long = 0
    var right: Long = arr.max()
    var result: Long = 0

    while (left <= right) {
        var h: Long = (left + right) / 2
        var tmp: Long = 0

        for (a in arr)
            if (a > h)
                tmp += (a - h)

        if (tmp >= m) left = (h + 1).also { result = maxOf(result, h) }
        else right = h - 1
    }

    return result
}

fun boj_2805() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }

    arr = readLine().split(" ")
        .map { it.toLong() }
        .toLongArray()

    print(solve(m))
}