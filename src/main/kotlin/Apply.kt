package org.example

fun main() {
    val client = DatabaseClient().apply {
        url = "localhost:3306"
        username = "root"
        password = "1234"
    }.connect().run { println(this) }
    // apply는 마지막줄의 결과가 아닌 객체 자체를 반환함


}