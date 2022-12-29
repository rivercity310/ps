package boj.beginner.b_Greedy

import java.util.PriorityQueue

private val pq = PriorityQueue<Int>()

// 10, 20, 25, 27
// 30, 25, 27        -> += 30
// 52, 30            -> += 52
// 82                -> += 82

private fun solve(): Int {
    var ans = 0 //
    while (pq.size >= 2) {
        val p1 = pq.poll()
        val p2 = pq.poll()
        ans += p1 + p2
        pq.add(p1 + p2)
    }

    return ans
}

fun boj_1715() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    for (i in 0 until n) pq.add(readLine().toInt())
    println(solve())
}

// 10 20 40
// (10 + 20) + (30 + 40) =

// 10 20 25 27
// (10 + 20) + (30 + 25) + (55 + 27) = 30 + 55 + 82 = 167
// (10 + 20) + (25 + 27) + (30 + 52) = 30 + 52 + 82 = 164