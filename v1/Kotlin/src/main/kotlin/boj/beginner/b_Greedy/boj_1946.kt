package boj.beginner.b_Greedy

private var arr = ArrayList<Pair<Int, Int>>()

private fun solve(): Int {
    // (1, 4), (2, 3), (3, 2), (4, 1), (5, 5)
    // (1, 4), (2, 5), (3, 6), (4, 2), (5, 7), (6, 1), (7, 3)
    var cnt = 1
    var tmp = arr[0].second

    for (i in 1 until arr.size) {
        if (arr[i].second < tmp) {
            cnt++
            tmp = arr[i].second
            if (tmp == 1) break
        }
    }

    return cnt
}

fun boj_1946() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val n = readLine().toInt()

        repeat(n) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            arr.add(Pair(a, b))
        }

        arr.sortBy { it.first }
        println(solve())
        arr = ArrayList()
    }
}