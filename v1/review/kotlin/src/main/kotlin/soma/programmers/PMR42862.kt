package soma.programmers

class PMR42862 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val reserved = BooleanArray(n + 1) { false }
        val ls = lost.sorted().filter { it !in reserve }
        val res = reserve.sorted().filter { it !in lost }
        var ans = n - ls.size


        for (l in ls) {
            for (r in res) {
                if (reserved[r])
                    continue

                if (l - r == 1) {
                    ans++
                    reserved[r] = true
                    break
                }

                if (r - l == 1) {
                    ans++
                    reserved[r] = true
                    break
                }
            }
        }

        return ans
    }

    fun main() {
        val ns = listOf(5, 5, 3, 4)
        val losts = listOf(
            intArrayOf(2, 4),
            intArrayOf(2, 4),
            intArrayOf(3),
            intArrayOf(1, 3)
        )
        val reserve = listOf(
            intArrayOf(1, 3, 5),
            intArrayOf(3),
            intArrayOf(1),
            intArrayOf(1, 3)
        )

        for (i in 0 until 4) {
            println(solution(ns[i], losts[i], reserve[i]))
        }
    }
}