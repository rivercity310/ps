package beginner.h_DivideAndConquer

private val a = mutableListOf<IntArray>()
private val b = mutableListOf<IntArray>()

fun boj_2740() = with(System.`in`.bufferedReader()){
    for (i in 0 until 2) {
        val (n, m) = readLine()
            .split(" ")
            .map { it.toInt() }

        repeat(n) {
            val tmp = readLine()
                .split(" ")
                .map { it.toInt() }
                .toIntArray()

            if (i == 0) a.add(tmp)
            else b.add(tmp)
        }
    }

    // b.size == a[0].size -> a의 열과 b의 행이 같음
    for (k in 0 until a.size) {
        for (i in 0 until b[0].size) {
            var sum = 0
            for (j in 0 until b.size) {
                sum += a[k][j] * b[j][i]
            }

            print("$sum ")
        }
        println()
    }
}