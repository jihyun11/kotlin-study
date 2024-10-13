package org.example

// f((1, 3)) = 1 + 3 = 4
// f(1, 3) = 1 + 3 = 4

// data class Tuple (val a: Int, val b: Int)

fun plus (pair: Pair<Int, Int>): Int {
    return pair.first + pair.second
}

fun main() {
    // println(plus(1, 3))
    println(plus(Pair(1,10)))

    val pair = Pair("A", 1)

    // pair는 데이터 클래스이다
    // 그래서 copy()가 지원됨
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    // 이때 만들어지는 list는 inmutable 형태의 불변 리스트
    val list = newPair.toList()
    println(list)

    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    triple.third
    val newTriple = triple.copy(third = "D")
    println(newTriple)
    println(newTriple.component3())

    // 구조분해 문법
    // .componentN() 을 사용해서 가져오는 것뿐이다
    val (a: String, b: String, c: String) = newTriple
    println("a = $a, b = $b, c = $c")

    val list3 = newTriple.toList()
    val (a1, b1, c1) = list3
    println("a = $a1, b = $b1, c = $c1")

    // 배열에서는 5개까지 쓸 수 있음
    list3.component1()
    list3.component2()
    list3.component3()
//    list3.component4()
//    list3.component5()

    // for문 돌릴때의 구조분해 문법
    val map = mutableMapOf<String, String>(Pair("이상훈", "개발자"))
    for ((key, value) in map) {
        println("${key}의 직업은 ${value}")
    }

}