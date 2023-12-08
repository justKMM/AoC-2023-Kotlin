package day02

import util.readInput
import java.util.*
import kotlin.reflect.typeOf



// input
val input = readInput(day = "02")


fun main() {
    part_2()
}

// Part 1
// max cubes of colors
const val red_max = 12
const val green_max = 13
const val blue_max = 14


fun part_1() {
    var sum = 0
    // iterate through strings of input
    for (string in input) {
        // init Scanner
        var sc = Scanner(string)
        var valid = true
        // string "Game"
        sc.next()
        // remove ":", convert to int
        var id = sc.next().removeSuffix(suffix = ":").toInt()
        // loop through not-last colors of turn
        while (sc.hasNext()) {
            // next number & color (suffix "," and ";" removed)
            var num = sc.nextInt()
            var color = sc.next().removeSuffix(",").removeSuffix(";")
            // call function to check whether number of cubes is valid, return a bool
            var check = checkColor(color = color, num = num)
            // if number of cubes not within allowed range
            if (!check) {
                valid = false
                break
            }
        }
        // if string doesn't have any more element (game is valid)
        if (valid) {
            sum += id
        }
        sc.close()
    }

    print(sum)
}

// function to check if number of cubes is within allowed range (0 -> max)
fun checkColor(color: String, num: Int): Boolean {
    when (color) {
        "red" -> return num <= red_max
        "green" -> return num <= green_max
        "blue" -> return num <= blue_max
    }
    return false
}



// Part 2
// min number of cubes of each color of each turn
var red = 0
var blue = 0
var green = 0
fun part_2() {
    var sum = 0
    // iterate through strings of input (through games)
    for (string in input) {
        // reset max values of each cube type
        red = 0; blue = 0; green = 0;
        // init Scanner
        var sc = Scanner(string)
        // string "Game"
        sc.next()
        // remove ":", convert to int
        var id = sc.next().removeSuffix(suffix = ":").toInt()
        // split string of game to an array of turns in that game
        var data_arr = sc.nextLine().split(";")
        // iterate through these turns
        for (inner_arr in data_arr) {
            // init inner scanner
            var scanner = Scanner(inner_arr)
            // iterate through inner scanner
            while (scanner.hasNext()) {
                // next number & color (suffix "," and ";" removed)
                var num = scanner.nextInt()
                var color = scanner.next().removeSuffix(",")
                // call function to find min number of cubes
                checkColor_2(color = color, num = num)
            }
        }
        sum += red*blue*green

    }
    print(sum)

}

// function to check if number of cubes is within allowed range (0 -> max)
fun checkColor_2(color: String, num: Int) {

    when (color) {
        "red" -> {
            if (num > red) red = num
        }
        "green" -> {
            if (num > green) green = num
        }
        "blue" -> {
            if (num > blue) blue = num
        }
    }
}