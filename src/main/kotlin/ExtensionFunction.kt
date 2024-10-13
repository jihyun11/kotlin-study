package org.example

// this -> 확장이 되는 대상
fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

// 기존에 존재하는 멤버 함수와, 확장 함수의 이름이 똑같을 때?
// 멤버 함수가 우선권을 가진다
class MyExample {
    fun printMessage() = println("클래스 출력")
}

// 인자가 다르면 인정
fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) {
        println("널인 경우에만 출력")
    } else println("널이 아닌 경우에만 출력")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    println("==================")

    MyExample().printMessage("확장 출력")

    println("==================")

    var myExample: MyExample? = null
    // myExample? 로 안써도 에러 안나는 이유: 해당 확장 함수에서 널 안정성 체크 하고 있기 때문에
    myExample.printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()


}