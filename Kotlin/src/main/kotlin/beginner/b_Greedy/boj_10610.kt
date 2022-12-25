package beginner.b_Greedy

fun boj_10610() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val digits = IntArray(10) { 0 }
    var ans = 0

    // 모든 자리의 수 합이 3의 배수(ans) && 0이 한개 이상 포함(digits[0]) => 30의 배수
    for (c in s) {
        digits[c - '0']++
        ans += (c - '0')
    }

    if (digits[0] > 0 && ans % 3 == 0) {
        for (i in 9 downTo 0)
            for (j in 0 until digits[i])
                print(i)
    }
    else print("-1")
}