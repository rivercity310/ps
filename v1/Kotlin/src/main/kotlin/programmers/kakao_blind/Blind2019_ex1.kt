package programmers.kakao_blind

class Blind2019_ex1 {
    fun solution(n: Int, stages: IntArray): IntArray {
        val rst = ArrayList<Pair<Double, Int>>()

        generateSequence(1) { it + 1 }.takeWhile { it <= n }
            .forEach { stage ->
                val done = stages.count { it >= stage }
                val challenging = stages.count { it == stage }
                val fail: Double = if (done == 0) 0.0 else challenging / done.toDouble()
                rst.add(fail to stage)
            }

        return rst.sortedWith(compareBy<Pair<Double, Int>> { -it.first }
            .thenBy { it.second })
            .map { it.second }
            .toIntArray()
    }
}

fun blind2019_ex1() {
    val test = arrayOf(intArrayOf(2, 1, 2, 6, 2, 4, 3, 3), intArrayOf(4, 4, 4, 4, 4))
    val N = intArrayOf(5, 4)

    for (i in test.indices) {
        Blind2019_ex1().solution(N[i], test[i]).forEach { print("$it ") }
        println()
    }
}