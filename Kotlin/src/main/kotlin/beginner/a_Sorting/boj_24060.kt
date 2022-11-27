package beginner.a_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader

var cnt = 0
var ans = -1
lateinit var tmp: IntArray

fun merging(arr: IntArray, left: Int, mid: Int, right: Int, k: Int) {
    var (i, j, t) = intArrayOf(left, mid + 1, left)

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) tmp[t++] = arr[i++]
        else tmp[t++] = arr[j++]
    }

    while (i <= mid) tmp[t++] = arr[i++]
    while (j <= right) tmp[t++] = arr[j++]

    for (a in left..right) {
        if (++cnt == k) {
            ans = tmp[a]
            return
        }
        arr[a] = tmp[a]
    }
}

fun merge(arr: IntArray, left: Int, right: Int, k: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        merge(arr, left, mid, k)
        merge(arr, mid + 1, right, k)
        merging(arr, left, mid, right, k)
    }
}

fun boj_24060() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (_, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    val arr: IntArray = readLine()
        .split(" ")
        .map{ it.toInt() }
        .toIntArray()

    tmp = IntArray(arr.size)
    merge(arr, 0, arr.lastIndex, k)

    print(ans)
}