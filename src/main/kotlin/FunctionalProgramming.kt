package org.example

fun main() {

//    val list = mutableListOf(printHello)
//
//    val func = list[0]
//    func()

//    call(printHello)

//    val list = mutableListOf(printNo())

//    val result = plus(1, 3, 5)
//    println(result)

//    val list = listOf("a", "b", "c")
//    val printStr : (String) -> Unit = { println(it) }
//
//    forEachStr(list, printStr)
//    list.forEach(printStr)
//
//    // 후행람다전달 기법
//    forEachStr(list) { println(it) }
//    list.forEach { println(it) }
//    list.forEach {
//        it == "a"
//    }


//
//    val upperCase: (String) -> String = { it.uppercase() }
//    list.map { it.uppercase() }
//    list.map(upperCase)

//    // 익명함수 호출법 (1)
//    outerFunc()()
//
//    // 익명함수 호출법 (2)
//    val func = outerFunc()
//    func()
//
//
//    arg1 {
//        it.length
//        it.first()
//    }
//
//    // 인자가 2개 이상일 경우에는 it을 못 쓰고 따로 명시해 주어야 한다
//    arg2{ a, b ->
//        a.length
//        b.length
//    }

    // 람다 레퍼런스
//    val callReference: () -> Unit = { printHello() }
    val callReference = ::printHello
    callReference()()

    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println(it) }
    // 람다 레퍼런스 사용
    numberList.map(String::toInt).forEach(::println)

}

fun arg1(block: (String) -> Unit) {}

fun arg2(block: (String, String) -> Unit) {}

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
// 최대한 생략
val sum2 = { x: Int, y: Int -> x + y}


// 익명함수
 fun outerFunc(): () -> Unit {
     return fun() {
         println("이것은 익명함수!")
     }
 }


fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}



// 인자 타입이 String인 함수를 받아서 Unit 타입의 무언가를 반환
val printMessage: (String) -> Unit = { message: String -> println(message) }
// 변수의 타입은 생략 가능
val printMessage2: (String) -> Unit = { message -> println(message) }
// 위보다 더 생략 가능
val printMessage3: (String) -> Unit = { println(it) }


val plus: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }


val printHello: () -> Unit = { println("Hello") }
val func: () -> String = { "" }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

// fun으로 선언할 경우, 1급 객체의 특성(함수를 인자로 넘기거나, 결과로 반환하거나, 값처럼 취급한다)을 가지지 않는다!!!
fun printNo() = println("No")