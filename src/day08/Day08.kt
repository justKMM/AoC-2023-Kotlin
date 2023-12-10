package day08

import util.readInput
import java.util.LinkedList
import java.util.Queue

// get input
val input = readInput(day = "08").filter { it != "" }
fun main() {
    print(part_1())
}

/*
 * Part 1
 */
var counter = 0
val instructions = input[0]
// taking the input binary tree, and join it into a string for further modifications
val tree = input.drop(0).joinToString(separator = " ") { it -> it }
// map of tree
val map = parseInputToMap(input = tree)
// starting node
val start = "AAA"

// queue for BFS
var queue:Queue<String> = LinkedList()
fun part_1(): Int {
    var currentNode = start
    val length = instructions.length
    var index = 0
    while (index < length) {
        if (counter==100000) {
            println(currentNode)
            return counter
        }
        // end of journey
        if (currentNode == "ZZZ") return counter
        // either go left or go right
        if (instructions[index] == 'L') map[currentNode]!![0].also { currentNode = it }
        else if (instructions[index] == 'R') map[currentNode]!![1].also { currentNode = it }
        counter++
        // end of instruction
        if (index == length - 1) {
            index = 0
            continue
        }
        index++
    }
    return 0
}

// using regex to turn string into a map
fun parseInputToMap(input: String) : Map<String, List<String>> {
    val entryRegex = Regex("""(\w+)\s*=\s*\(([\w\s,]+)\)""")

    return entryRegex.findAll(input)
        .map { matchResult ->
            val (key, values) = matchResult.destructured
            key to values.split(", ").toList()
        }
        .toMap()
}