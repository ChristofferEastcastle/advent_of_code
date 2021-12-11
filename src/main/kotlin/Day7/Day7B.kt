package Day7

import java.io.File
import kotlin.math.abs

fun main() {
    Day7B().solve()
}

class Day7B {
    fun solve() {
        val input = File("input7.txt").readText().strip().split(",").map { s -> s.toInt() }
        var least = -1

        for (i in input.indices) {
            var total = 0
            for (j in input) {
                var fuel = 1
                for (k in 0 until abs(j - i)) {
                    total += fuel++
                }
            }
            if (least == -1) least = total
            else if (total < least) least = total
        }
        println(least)
    }
}


