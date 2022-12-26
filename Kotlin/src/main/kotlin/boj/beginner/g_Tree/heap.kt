package boj.beginner.g_Tree

private class Heapq {
    private val heap = IntArray(100) { 0 }
    private var size = 0

    fun insert_heap(data: Int): Unit {
        var i = ++size

        while ((i != 1) && data > heap[i / 2]) {
            heap[i] = heap[i / 2]
            i /= 2
        }

        heap[i] = data
    }

    fun delete_heap(): Int {
        val root = heap[1]
        val last = heap[size--]

        var parent = 1
        var child = 2

        while (child <= size) {
            if (child < size && heap[child] < heap[child + 1]) child++
            if (last >= heap[child]) break

            heap[parent] = heap[child]
            parent = child
            child *= 2
        }

        heap[parent] = last
        return root
    }

    fun peek_heap(): Int = heap[1]
}

fun heap_test() {
    val h = Heapq()

    for (i in 1..10) h.insert_heap(i)
    for (i in 1..10) print("${h.delete_heap()} ")
}