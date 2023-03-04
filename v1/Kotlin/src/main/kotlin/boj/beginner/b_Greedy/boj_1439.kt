package boj.beginner.b_Greedy

fun boj_1439() = with(System.`in`.bufferedReader()) {
    val s = readLine().replace(Regex("0+"), "0").replace(Regex("1+"), "1")
    println(minOf(s.count { it == '0' }, s.count { it == '1' }))
}