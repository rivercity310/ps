package boj.beginner.b_Greedy

fun boj_1789() = with(System.`in`.bufferedReader()) {
    val S = readLine().toLong() * 2
    var n: Long = 0

    while (true) {
        if (n * (n + 1) <= S) n++
        else break
    }

    print(n - 1)
}