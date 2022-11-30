package beginner.h_DivideAndConquer

/* 시간초과
private fun solve(a: Int, b: Int, c: Int): Int =
    when {
        b == 1 -> a % c
        b % 2 == 1 -> ((a % c) * (solve(a, b - 1, c) % c) % c)
        else -> ((solve(a, b / 2, c) % c) * (solve(a, b / 2, c) % c) % c)
    }
*/

private fun solve(a: ULong, b: ULong, c: ULong): ULong {
    if (b == 1UL) return a % c

    val tmp = solve(a, b / 2UL, c)

    if (b % 2UL == 1UL) return (tmp * tmp % c) * a % c
    return tmp * tmp % c
}

fun boj_1629() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine()
        .split(" ")
        .map { it.toULong() }

    print(solve(a, b, c))
}