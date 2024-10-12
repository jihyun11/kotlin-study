package org.example

fun main() {
    val day = 2

    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타요일"
    }
    println(result)

    when (getColor()) {
        Color.RED -> println("RED")
        Color.ORANGE -> println("ORANGE")
        else -> println("Blue")
    }

    when (getNumber()) {
        0, 1 -> println("0 or 1")
        else -> println("0 또는 1이 아님")
    }


}

enum class Color {
    RED, ORANGE, BLUE
}

fun getColor() = Color.RED

fun getNumber() = 2