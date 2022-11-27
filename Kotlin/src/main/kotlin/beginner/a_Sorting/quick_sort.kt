package beginner.a_Sorting

// quick sort with kotlin style
// 매번 새로운 리스트를 만드므로 비효율적 ㅠㅠ
fun solve(arr: IntArray): IntArray {
    if (arr.size < 2)
        return arr

    val pivot = arr[arr.size / 2]
    val left = arr.filter { it < pivot }.toIntArray()
    val right = arr.filter { it > pivot }.toIntArray()

    return solve(left) + intArrayOf(pivot) + solve(right)
}

fun quick_sort() = with(System.`in`.bufferedReader()) {
    val arr = readLine()
        .split(" ")
        .map { it.toInt() }
        .toIntArray()

    val sorted_arr = solve(arr)

    println("[ 정렬 완료 ]")
    for (k in sorted_arr)
        print("$k ")
}