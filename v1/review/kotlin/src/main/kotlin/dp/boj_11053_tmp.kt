package dp

private lateinit var arr: IntArray
private lateinit var dp: IntArray

private fun solve(): Int {
    dp[1] = 1

    for (i in 2 until arr.size) {
        
    }

    return dp.last()
}

fun boj_11053() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    dp = IntArray(n) { 0 }
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    print(solve())
}