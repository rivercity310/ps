package soma.programmers

class PMR42578 {
    private fun solution(clothes: Array<Array<String>>): Int {
        return clothes
            .groupBy { it[1] }
            .values
            .map { it.size + 1 }
            .reduce(Int::times)
            .minus(1)
    }

    fun main() {
        val clothes = arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )

        print(solution(clothes))
    }
}