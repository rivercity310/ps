package programmers.kakao_internship2022

private val orders = listOf("RT", "CF", "JM", "AN")

private class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {

        // 1. mapIndexed: { ('N', 1), ('C', 1), ('M', 2), ('T', 3), ('A', 1) }
        // 2. groupBy: { 'A': { ('A', 1) }, 'C': { ('C', 1) }, 'N': { ('N', 1) }, 'M': { ('M', 2) }, 'T': { ('T', 3) } }
        // 3. map: { ('A', 1), ('C', 1), ('N', 1), ('M', 2), ('T', 3) }
        // 4. toMap: { 'A': 1, 'C': 1, 'N': 1, 'M': 2, 'T': 3 }
        // 5. let: { 'T', 'C', 'M', 'A' }
        // 6. joinToString: "TCMA"

        return choices
            .mapIndexed { index, elem ->
                if (elem < 4) survey[index][0] to -(elem - 4)
                else survey[index][1] to (elem - 4)
            }
            .groupBy { it.first }
            .map { it.key to it.value.sumOf { v: Pair<Char, Int> -> v.second } }
            .toMap()
            .let { ans: Map<Char, Int> ->
                orders.map {
                    if (ans.getOrDefault(it[0], 0) >= ans.getOrDefault(it[1], 0))
                        it[0] else it[1]
                }
            }
            .joinToString("")
    }
}

fun internship2022_ex1() {
    val test = Solution()
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choices = intArrayOf(5, 3, 2, 7, 5)

    val phase1 = choices.mapIndexed { index, i ->
        if (i - 4 < 0) survey[index][0] to -(i - 4)
        else survey[index][1] to (i - 4)
    }
    println("Phase1: $phase1")

    val phase2 = phase1.groupBy { it.first }
    println("Phase2: $phase2")

    val phase3 = phase2.map { it.key to it.value.sumOf { v: Pair<Char, Int> -> v.second } }
    println("Phase3: $phase3")

    val phase4 = phase3.toMap()
    println("Phase4: $phase4")

    val phase5 = phase4.let { ans: Map<Char, Int> ->
        orders.map {
            if (ans.getOrDefault(it[0], 0) >= ans.getOrDefault(it[1], 0)) it[0] else it[1]
        }
    }
    println("Phase5: $phase5")

    val phase6 = phase5.joinToString("")
    println("Phase6: $phase6")

    println(test.solution(survey, choices))

    println("hello vim")
}