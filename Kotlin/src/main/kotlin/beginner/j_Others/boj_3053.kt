package beginner.j_Others

import kotlin.math.pow

fun boj_3053() = with(System.`in`.bufferedReader()) {
    val r = readLine().toDouble()
    val a = Math.PI * r.pow(2.0)
    val b = 2 * r.pow(2.0)

    println("%.6f".format(a))
    println("%.6f".format(b))
}