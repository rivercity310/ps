package programmers.kakao_blind


private class Blind2021_ex1 {

    fun String.checkStr(): String {
        if (this.isEmpty()) return "a"
        else if (this.length >= 16) {
            val str = this.substring(0, 15)
            return if (str.endsWith('.')) str.substring(0, 14)
            else str
        }
        return this
    }

    fun String.checkSize(): String {
        var str = this
        while (str.length < 3)
            str += this.last()

        return str
    }

    fun solution(new_id: String): String {
        return new_id
            .map { it.lowercaseChar() }
            .filter { it in '0'..'9' || it in 'a'..'z' || it in "-_." }
            .joinToString("")
            .split(".")
            .filter { it.isNotEmpty() }
            .joinToString(".")
            .checkStr()
            .checkSize()
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