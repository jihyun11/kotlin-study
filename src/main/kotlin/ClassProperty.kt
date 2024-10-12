package org.example

// coffee 클래스의 name이라는 프로퍼티
class Coffee constructor(
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,
) {
    // 나만의 getter 커스텀 하기
    val brand: String
        get() {
            return "스타벅스"
        }

    // 나만의 setter 커스텀 하기
    var quantity: Int = 0
        set(value) {
            if (value > 0) { // 수량이 0 이상인 경우에만 할당
                // backing field에 접근한다
                field = value
//                quantity = value 이렇게 쓰면 무한재귀 걸림
            }
        }
}

// 본문 내용이 없는 클래스도 만들기 가능
class EmptyClass

fun main() {
    val coffee = Coffee()
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 커피")
    }

    println("${coffee.name}, ${coffee.price}, ${coffee.brand}, ${coffee.quantity}")
}