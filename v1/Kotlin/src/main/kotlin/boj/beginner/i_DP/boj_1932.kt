package boj.beginner.i_DP

import java.util.StringTokenizer

private lateinit var tri: Array<ArrayList<Int>>

private fun solve(n: Int): Int {

    // tri[1][0] += tri[0][0]
    // tri[1][1] += tri[0][0]

    /*
    tri[2][0] = tri[1][0] + tri[2][0]
    tri[2][1] = maxOf(tri[1][0] + tri[2][1], tri[1][1] + tri[2][1])
    tri[2][2] = tri[1][1] + tri[2][2]
    */

    for (i in 1 until n) {
        tri[i][0] += tri[i - 1][0]
        for (j in 1 until i) tri[i][j] += maxOf(tri[i - 1][j - 1], tri[i - 1][j])
        tri[i][tri[i].lastIndex] += tri[i - 1][i - 1]
    }

    return tri[n - 1].max()
}

fun boj_1932() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tri = Array(n) { arrayListOf() }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        while (st.hasMoreTokens()) tri[i].add(st.nextToken().toInt())
    }

    println(solve(n))
}