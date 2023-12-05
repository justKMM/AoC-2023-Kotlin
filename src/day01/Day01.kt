package day01

fun main() {

    val input = readInput("01")
    var sum = 0
    //Iterate through strings
    for (string in input) {
        var num = ""
        // Iterate through each string
        for (char in string) {
            if (char.isDigit()) {
                num += char
                break
            }
        }
        // Iterate through each string reversed
        for (char in string.reversed()) {
            if (char.isDigit()) {
                num += char
                break
            }
        }

        sum += num.toInt()
    }
    print(sum)

}


