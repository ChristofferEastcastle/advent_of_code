package Day6

import java.io.File

fun main() {
    solve()

}


fun solve() {
    val input = File("input6.txt").readText()
        .split(",").map { s -> s.toLong() }
    val arr = mutableListOf(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L)
    for (i in input) {
        arr[i.toInt()]++
    }
    println(arr)
    for (i in 0 until 256) {
        arr.add(arr.removeAt(0))
        arr[6] += arr[8]
    }
    println(arr.sum())
}