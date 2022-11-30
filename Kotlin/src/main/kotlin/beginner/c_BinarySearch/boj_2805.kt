package beginner.c_BinarySearch

import java.io.BufferedReader
import java.io.InputStreamReader

private fun solve(arr: LongArray, m: Int): Long {
    var start: Long = 0
    var end: Long? = arr.maxOrNull()

    while (start < end!!) {
        val mid: Long = (start + end) / 2
        var tmp: Long = 0

        for (a in arr)
            if (a > mid)
                tmp += a - mid

        if (tmp < m) end = mid
        else start = mid + 1
    }

    return end - 1
}

fun boj_2805() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n: Int, m: Int) = readLine()
        .split(" ")
        .map { it.toInt() }

    val arr: LongArray = readLine()
        .split(" ")
        .map { it.toLong() }
        .toLongArray()

    /*
    val arr = emptyList<Int>().toMutableList();
    for (i in 0 until n)
        arr.add(readLine()!!.toInt())
    */

    println(solve(arr, m))
}