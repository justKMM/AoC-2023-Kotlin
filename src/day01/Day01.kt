package day01

import util.readInput

fun main() {
    // input
    val input = readInput(day = "01")
    var sum = 0
    //Iterate through strings of input
    for (string in input) {
        var num = ""
        // Iterate through each string
        var left = ""
        for (char in string) {
            if (char.isDigit()) {
                num += char
                break
            }
            // Increase left string by 1 char
            left+=char
            // Convert String -> char of int
            var leftAfterCheck = checkNum(left)
            if(leftAfterCheck.isDigit()) {
                num+=leftAfterCheck
                break
            }

        }

        // Iterate through each string reversed
        var right = ""
        for (char in string.reversed()) {
            if (char.isDigit()) {
                num += char
                break
            }
            right = char + right
            var rightAfterCheck = checkNum(right)
            if(rightAfterCheck.isDigit()) {
                num+=rightAfterCheck
                break
            }

        }

        sum += num.toInt()
    }
    print(sum)

}

fun checkNum(string: String): Char {

    if (string.contains("one")) return '1'
    if (string.contains("two")) return '2'
    if (string.contains("three")) return '3'
    if (string.contains("four")) return '4'
    if (string.contains("five")) return '5'
    if (string.contains("six")) return '6'
    if (string.contains("seven")) return '7'
    if (string.contains("eight")) return '8'
    if (string.contains("nine")) return '9'
    else return ' '

}

