package programmers.devMatching2021

private class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val n = lottos.size
        var cor = 0
        var zero = 0
        val wrong by lazy { n - cor - zero }

        lottos.forEach {
            if (it == 0) zero++
            else if (it in win_nums) cor++
        }

        return when {
            cor == n -> intArrayOf(1, 1)
            wrong == n -> intArrayOf(6, 6)
            zero == n -> intArrayOf(1, 6)
            else -> intArrayOf(wrong + 1, wrong + zero + 1)
        }
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
    val (max, min) = Solution2().solution(lottos, win_nums)
    println("max: $max, min: $min")
}