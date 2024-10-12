package org.example

fun main() {
    for (i in 0 .. 3) {
        println(i)
    }

    for (i in 0 until 3) {
        println(i)
    } // 3은 포함하지 않는다

    for (i in 0..6 step 2) {
        println(i)
    } // step에 들어온 값만큼 증가시킨다

    for (i in 3 downTo 0) {
        println(i)
    } // 3부터 0까지 감소시킨다

    val numbers = arrayOf(1, 2, 3)

    for (i in numbers) {
        println(i)
    }
}