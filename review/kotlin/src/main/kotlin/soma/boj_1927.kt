package soma

import java.util.PriorityQueue

fun boj_1927() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()
    val sb = StringBuffer()

    repeat(n) {
        val x = readLine().toInt()
        if (x == 0) sb.append(pq.poll() ?: 0).append('\n')
        else pq.add(x)
    }

    print(sb)
}