package programmers.devMatching2021

private class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val n = lottos.size
        var cor = 0
        var zero = 0
        var wrong = 0

        return lottos.map {
            when (it) {
                0 -> zero++
                in win_nums -> cor++
                else -> wrong++
            }
        }.run { when {
            cor == n -> intArrayOf(1, 1)
            zero == n -> intArrayOf(1, 6)
            wrong == n -> intArrayOf(6, 6)
            else -> intArrayOf(wrong + 1, n - cor + 1)
        }}
    }
}

private class Solution2 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        return intArrayOf(
            lottos.size.plus(1) - lottos.filter { it in win_nums || it == 0 }.size,
            lottos.size.plus(1) - lottos.filter(win_nums::contains).size
        )
            .map { if (it > 6) it - 1 else it }
            .toIntArray()
    }
}

fun backend_ex1() {
    val lottos = intArrayOf(0, 0, 0, 0, 0, 0)
    val win_nums = intArrayOf(38, 19, 20, 40, 15, 25)
    val (max, min) = Solution().solution(lottos, win_nums)
    println("$max $min")
}