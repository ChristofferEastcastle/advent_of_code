package Day7

import java.io.File
import kotlin.math.abs

fun main() {
    Day7().solve()
}

class Day7 {
    fun solve() {
        val input = File("input7.txt").readText().strip().split(",").map { s -> s.toInt() }

        var least = -1

        for (i in input.indices) {
            var total = 0
            for (j in input) {
                total += abs(j - i)
            }
            if (least == -1) least = total
            else if (total < least) least = total
        }
        println(least)
    }
}


