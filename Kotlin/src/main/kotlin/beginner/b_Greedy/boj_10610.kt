package beginner.b_Greedy

private lateinit var s: CharArray


fun boj_10610() = with(System.`in`.bufferedReader()) {
    s = readLine().toCharArray()
    s.sortDescending()

}