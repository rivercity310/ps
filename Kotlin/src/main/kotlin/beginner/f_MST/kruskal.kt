package beginner.f_MST


data class ND(val src: Int, val dst: Int, val weight: Int) : Comparable<ND> {
    override fun compareTo(other: ND): Int {
        return this.weight - other.weight
    }
}

class DisjointSet(val n: Int) {
    val parent = IntArray(n)

    init {
        for (i in 0 until n)
            parent[i] = i
    }

    fun find_parent(x: Int): Int {
        if (parent[x] != x)
            parent[x] = find_parent(parent[x])
        return parent[x]
    }

    fun union_parent(a: Int, b: Int) {
        val ra = find_parent(a)
        val rb = find_parent(b)

        if (ra < rb) parent[rb] = ra
        else parent[ra] = rb
    }
}

fun solve(grp: MutableList<ND>, n: Int): Int {
    val dset = DisjointSet(grp.size)
    var rst = 0

    for (i in 0 until grp.size) {
        val nd = grp[i]

        if (dset.find_parent(nd.src) != dset.find_parent(nd.dst)) {
            println("(${nd.src}, ${nd.dst}, ${nd.weight})를 MST에 추가")
            dset.union_parent(nd.src, nd.dst)
            rst += nd.weight
        }
    }

    return rst
}

fun kruskal_test() = with(System.`in`.bufferedReader()) {
    val (n, e) = readLine()
        .split(" ")
        .map { it.toInt() }

    val grp = mutableListOf<ND>()

    repeat(e) {
        val (u, v, w) = readLine()
            .split(" ")
            .map { it.toInt() }

        grp.add(ND(u, v, w))
    }

    grp.sort()

    for (nd in grp)
        println("(${nd.src}, ${nd.dst}, ${nd.weight})")

    println("\nweight = ${solve(grp, n)}")
}