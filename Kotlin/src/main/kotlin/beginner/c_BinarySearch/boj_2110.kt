package beginner.c_BinarySearch

private fun solve(arr: MutableList<Int>, c: Int): Int {

    fun install(mid: Int): Int {
        var router = 1
        var last = arr[0]

        for (i in 1 until arr.size) {
            val loc = arr[i]

            if (loc >= last + mid) {
                router++
                last = loc
            }
        }

        return router
    }

    var left = 1
    var right = arr[arr.lastIndex] - arr[0]
    var ans = 0

    while (left <= right) {
        val mid = (left + right) / 2
        val router = install(mid)

        if (router < c) right = mid - 1
        else {
            ans = maxOf(ans, mid)
            left = mid + 1
        }
    }

    return ans
}

fun boj_2110() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine()
        .split(" ")
        .map { it.toInt() }

    val arr = mutableListOf<Int>()
    repeat(n) {
        arr.add(readLine().toInt())
    }

    arr.sort()
    print(solve(arr, c))
}