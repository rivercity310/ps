package KAKAO2022_INTERNSHIP

private class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val chr = charArrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
        val cnt = IntArray(8) { 0 }

        var answer = ""

        for (i in survey.indices) {
            val str = survey[i]
            val a = choices[i]

            when (str) {
                "RT", "TR" -> {
                    if (str[0] == 'R') {
                        if (a < 4) cnt[0] += 4 - a
                        else cnt[1] += a % 4
                    }

                    else {
                        if (a < 4) cnt[1] += 4 - a
                        else cnt[0] += a % 4
                    }
                }

                "CF", "FC" -> {
                    if (str[0] == 'C') {
                        if (a < 4) cnt[2] += 4 - a
                        else cnt[3] += a % 4
                    }

                    else {
                        if (a < 4) cnt[3] += 4 - a
                        else cnt[2] += a % 4
                    }
                }

                "JM", "MJ" -> {
                    if (str[0] == 'J') {
                        if (a < 4) cnt[4] += 4 - a
                        else cnt[5] += a % 4
                    }

                    else {
                        if (a < 4) cnt[5] += 4 - a
                        else cnt[4] += a % 4
                    }
                }

                "AN", "NA" -> {
                    if (str[0] == 'A') {
                        if (a < 4) cnt[6] += 4 - a
                        else cnt[7] += a % 4
                    }

                    else {
                        if (a < 4) cnt[7] += 4 - a
                        else cnt[6] += a % 4
                    }
                }
            }
        }

        for (i in 1 until cnt.size step 2) {
            if (cnt[i - 1] < cnt[i]) answer += chr[i]
            else if (cnt[i - 1] > cnt[i]) answer += chr[i - 1]
            else answer += if (chr[i - 1] < chr[i]) chr[i - 1] else chr[i]
        }

        return answer
    }
}

fun personality_type_check() {
    val test = Solution()
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choices = intArrayOf(5, 3, 2, 7, 5)

    println(test.solution(survey, choices))
}