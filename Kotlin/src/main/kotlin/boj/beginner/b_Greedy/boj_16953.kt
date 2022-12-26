package boj.beginner.b_Greedy

fun boj_16953() = with(System.`in`.bufferedReader()) {
    var (a, b) = readLine().split(" ").map { it.toInt() }
    var cnt = 1

    while (a < b) {
        b /= if (b % 2 == 0) 2
        else if (b % 10 != 1) break
        else 10
        cnt++
    }

    print("${if (a == b) cnt else -1}")
}