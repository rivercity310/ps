package programmers.kakao_blind

import kotlin.math.pow

class Blind2018_ex1 {
    fun solution(dartResult: String): Int {
        val options = intArrayOf(1, 1, 1)
        val scores = intArrayOf(0, 0, 0)
        var str = ""
        var i = 0

        dartResult.forEach { c ->
            when (c) {
                in '0'..'9' -> str += c
                'S' -> scores[i] = str.toInt()
                'D' -> scores[i] = str.toDouble().pow(2).toInt()
                'T' -> scores[i] = str.toDouble().pow(3).toInt()
                '#' -> options[i - 1] = -options[i - 1]
                '*' -> {
                    if (i > 2) options[i - 1] *= 2
                    options[i - 1] *= 2
                }
            }

            if (c in "SDT") {
                i++
                str = ""
            }
        }

        for (k in scores) print("$k ")
        println(scores.mapIndexed { i, v -> v * options[i] })

        return scores
            .mapIndexed { i, v -> v * options[i] }
            .sum()
    }
}

fun blind2018_ex1() {
    val test = listOf(
        "1S2D*3T",
        "1D2S#10S",
        "1D2S0T",
        "1S*2T*3S",
        "1D#2S*3S"
        )

    for (str in test) println(Blind2018_ex1().solution(str))
}