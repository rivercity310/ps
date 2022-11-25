package beginner.g_Tree

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object boj_9934 {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private var st: StringTokenizer? = null
    private var arr: MutableList<Int>? = null
    private var stringbuilders: Array<StringBuilder?>
    private fun solve(left: Int, right: Int, depth: Int, k: Int) {
        if (depth > k) return
        val mid = (left + right) / 2
        stringbuilders[depth]!!.append(arr!![mid]).append(" ")
        solve(left, mid - 1, depth + 1, k)
        solve(mid + 1, right, depth + 1, k)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val k = br.readLine().toInt()
        val size = Math.pow(2.0, k.toDouble()).toInt() - 1
        arr = ArrayList(size)
        st = StringTokenizer(br.readLine())
        stringbuilders = arrayOfNulls(k + 1)
        Arrays.setAll(stringbuilders) { elem: Int -> StringBuilder() }
        for (i in 0 until size) arr.add(st!!.nextToken().toInt())
        solve(0, size - 1, 1, k)
        for (i in 1..k) println(stringbuilders[i])
    }
}