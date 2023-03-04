package boj.beginner.c_BinarySearch

private lateinit var arr: IntArray

// upper-bound
private fun solve(key: Int): Int {
    var left = 0
    var right = arr.lastIndex

    while (left < right) {
        val mid = (left + right) / 2
        if (arr[mid] > key) right = mid - 1
        else if (arr[mid] <= key) left = mid
    }

    return right
}

fun boj_12015() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    for (i in arr.indices) {
        val idx = solve(arr[i])
        println(idx)
    }
}