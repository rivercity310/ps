package programmers.kakao_blind


private class Blind2021_ex1 {
    fun String.checkStr(): String {
        if (this.isEmpty()) return "a"
        else if (this.length > 15) {
            val str = this.substring(0 until 15)
            return if (str.endsWith('.')) str.substring(0 until 14)
            else str
        }
        return this
    }

    /*
    fun String.checkSize(): String {
        val sb = StringBuilder(this)
        while (sb.length < 3)
            sb.append(this.last())

        return sb.toString()
    }
    */

    fun solution(new_id: String): String {
        return new_id
            .map { it.lowercaseChar() }
            .filter { it.isDigit() || it.isLowerCase() || it in "-_." }
            .joinToString("")
            .replace("[.]*[.]".toRegex(), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .checkStr()
            .let {
                StringBuilder(it).run {
                    while (length < 3) append(it.last())
                    toString()
                }
            }
    }
}

fun blind2021_ex1() {
    val id1 = "...!@BaT#*..y.a123bcdefghijklm"
    val id2 = "z-+.^."
    val id3 = "123_.def"
    val id4 = "abcdefghijklmn.p"
    val test = listOf(id1, id2, id3, id4)

    for (id in test) println(Blind2021_ex1().solution(id))
}