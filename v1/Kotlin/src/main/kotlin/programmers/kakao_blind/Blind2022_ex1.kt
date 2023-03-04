package programmers.kakao_blind

private class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
        report.map { it.split(" ") }
            .groupBy { it[1] }
            .asSequence()
            .map { it.value.distinct() }
            .filter { it.size >= k }
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount()
            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
}

fun blind2022_ex1() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k = 2
    val rst = Solution().solution(id_list, report, k)


    for (v in rst)
        print("$v ")
    println()

    val phase1 = report.map { it.split(" ") }.groupBy { it[1] }
    println("[ phase1 ]")
    for ((gr, lst) in phase1) {
        print("$gr : ")
        for (v in lst) print("$v ")
        println()
    }

    println("\n[ phase2 ]")
    val phase2 = phase1.asSequence().map { it.value.distinct() }  // distinct : 중복 제거, 세트로 바꿨다가 다시 리스트로 (toMutableSet().toList())
    for (lst1 in phase2) {
        for (lst2 in lst1)
            print("$lst2 ")
        println()
    }

    println("\n[ phase3 ]")
    val phase3 = phase2.filter { it.size >= k }.flatten()
    for (lst in phase3)
        print("$lst ")
    println()

    println("\n[ phase4 ]")
    val phase4 = phase3.map { it[0] }.groupingBy { it }.eachCount()
    for ((str, v) in phase4) {
        print("$str : $v ")
    }
    println()

    println("\n[ phase5 ]")
    val phase5 = phase4.run { id_list.map { getOrDefault(it, 0) } }.toIntArray()
    for (v in phase5)
        print("$v ")
}