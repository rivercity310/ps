package boj.beginner.a_Sorting

// 제자리 정렬을 사용해 메모리 효율적

private fun partition(arr: IntArray, start: Int, end: Int): Int {
    var left = start
    var right = end
    val pivot = arr[(left + right) / 2]

    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--

        if (left <= right) {
            arr[left] = arr[right].also { arr[right] = arr[left] }
            left++
            right--
        }
    }

    return left
}

private fun solve(arr: IntArray, left: Int = 0, right: Int = arr.lastIndex) {
    val index = partition(arr, left, right)

    if (left < index - 1)
        solve(arr, left, index - 1)
    if (index < right)
        solve(arr, index, right)
}

fun quick_sort2() = with(System.`in`.bufferedReader()) {
    val arr = readLine()
        .split(" ")
        .map { it.toInt() }
        .toIntArray()

    solve(arr)

    println("[ 정렬 완료 ]")
    for (k in arr)
        print("$k ")
}