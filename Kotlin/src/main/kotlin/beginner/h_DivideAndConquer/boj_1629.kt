package beginner.h_DivideAndConquer

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