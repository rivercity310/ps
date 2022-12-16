package beginner.g_Tree

private lateinit var tr: Array<Pair<Int, Int>>

private fun preorder(cur: Int): Unit {
    print((cur + 65).toChar())
    if (tr[cur].first != - 1) preorder(tr[cur].first)
    if (tr[cur].second != -1) preorder(tr[cur].second)
    return
}

private fun inorder(cur: Int): Unit {
    if (tr[cur].first != -1) inorder(tr[cur].first)
    print((cur + 65).toChar())
    if (tr[cur].second != -1) inorder(tr[cur].second)
    return
}

private fun postorder(cur: Int): Unit {
    if (tr[cur].first != -1) postorder(tr[cur].first)
    if (tr[cur].second != -1) postorder(tr[cur].second)
    print((cur + 65).toChar())
    return
}

fun boj_1991() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tr = Array(n) { Pair(-1, -1) }

    repeat(n) {
        val (root, left, right) = readLine()
            .split(" ")
            .map { it.single() }

        var (lf, rf) = Pair(-1, -1)
        if (left != '.') lf = left - 'A'
        if (right != '.') rf = right - 'A'
        tr[root - 'A'] = Pair(lf, rf)
    }

    preorder(0)
    println()
    inorder(0)
    println()
    postorder(0)
}