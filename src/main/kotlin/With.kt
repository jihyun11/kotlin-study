package org.example

fun main() {
    val str = "안녕하세요"

    val length = with(str) {
        length
    }
    println(length)
}