package boj.beginner.g_Tree

import java.lang.NullPointerException

private class Trie {
    class Node {
        val childNodes = HashMap<Char, Node>()
        var isFinal = false
    }

    val root = Node()

    fun insert(numbers: String): Boolean {
        var curNode = root

        numbers.forEach {
            if (curNode.childNodes[it] == null) curNode.childNodes[it] = Node()
            curNode = curNode.childNodes[it] ?: throw NullPointerException()
            if (curNode.isFinal) return false
        }

        if (curNode.childNodes.size != 0) return false
        curNode.isFinal = true
        return true
    }
}

fun boj_5052() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val n = readLine().toInt()
        val trie = Trie()
        var flag = true

        repeat(n) {
            if (!trie.insert(readLine())) flag = false
        }

        if (flag) sb.append("YES")
        else sb.append("NO")
        sb.append("\n")
    }

    print(sb)
}

fun boj_5052_2() = with(System.`in`.bufferedReader()) {

    fun checkContainsString(nums: List<String>): Boolean {
        for (i in 0 until nums.size - 1)
            if (nums[i + 1].startsWith(nums[i])) return false

        return true
    }

    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val n = readLine().toInt()
        val phoneNums = ArrayList<String>()
        var flag = true

        repeat(n) { phoneNums.add(readLine()) }

        if (!checkContainsString(phoneNums.sorted())) flag = false

        if (flag) sb.append("YES")
        else sb.append("NO")
        sb.append("\n")
    }

    print(sb)
}