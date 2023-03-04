package binarysearch

private lateinit var arr: IntArray
private lateinit var x: IntArray

private fun solve(v: Int): Int {
    var left = 0
    var right = arr.lastIndex

    while (left <= right) {
        val mid = (left + right) / 2
        if (arr[mid] == v) return 1
        else if (arr[mid] > v) right = mid - 1
        else left = mid + 1
    }

    return 0
}

fun boj_1920() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = readLine().split(" ")
        .map { it.toInt() }
        .sorted()
        .toIntArray()

    val m = readLine().toInt()
    x = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    for (i in 0 until m)
        println(solve(x[i]))
}