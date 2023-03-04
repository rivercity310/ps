package soma.programmers

class PMR86491 {

    // (60, 50), (70, 30), (60, 30), (80, 40)
    // width = 80, height = 50

    // (10, 7), (12, 3), (15, 8), (14, 7), (15, 5)
    // width = 15, height = 8
    fun solution(sizes: Array<IntArray>): Int {
        var width = 0
        var height = 0

        for (size in sizes) {
            size.sort()

            val w = size[1]
            val h = size[0]

            width = maxOf(width, w)
            height = maxOf(height, h)
        }

        return width * height
    }

    fun main() {
        val sizes = listOf(
            arrayOf(
                intArrayOf(60, 50),
                intArrayOf(30, 70),
                intArrayOf(60, 30),
                intArrayOf(80, 40)
            ),

            arrayOf(
                intArrayOf(10, 7),
                intArrayOf(12, 3),
                intArrayOf(8, 15),
                intArrayOf(14, 7),
                intArrayOf(5, 15)
            )
        )

        sizes.forEach { println(solution(it)) }
    }
}