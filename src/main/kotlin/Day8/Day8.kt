package Day8

import java.io.File

fun main() {
    Day8().solve()
}

class Day8 {
    fun solve() {
        var counter = 0
        for (line in File("input8.txt").readLines()) {
            for (s in line.split(" | ")[1].split(" ")) {
                when (s.length) {
                    2, 3, 4, 7 -> counter++
                }
            }
        }
        println(counter)
    }
}