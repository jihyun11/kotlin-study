package org.example

import java.util.*

fun main() {
    // inmutable
    val currencyList = listOf("달러", "유로", "원")

    // mutable
    val mutableCurrencyList = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    // inmutable set
    val numberSet = setOf(1,2,3,4,5)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }

    // inmutable map
    val numberMap = mapOf("one" to 1, "two" to 2, "three" to 3)

    // mutable map
    val mutablNumberMap = mutableMapOf<String, Int>()
    mutablNumberMap["one"] = 1
    mutablNumberMap["two"] = 2
    mutablNumberMap["three"] = 3


    // 컬렉션 빌더
    // buildList 내부에서는 mutable, 반환할 때는 inmutable 로 반환한다
    // 그래서 외부에서는 따로 add로 추가가 불가능함
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    // linkedList
    // 각 구현체의 생성자를 사용해서 추가하기도 가능함
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("==================")

    for (currency in currencyList) {
        println(currency)
    }

    println("==================")


    currencyList.forEach {
        println(it)
    }

    println("==================")


    // for loop -> map
    val lowerList = listOf("a", "b", "c")
    // val upperList = mutableListOf<String>()

//     for (loweCase in lowerList) {
//        upperList.add(loweCase.uppercase())
//    }

    val upperList = lowerList.map {
        it.uppercase()
    }

    println(upperList)

//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C") {
//            filteredList.add(upperCase)
//        }
//    }

    // 체인이 너무많아지면 시퀀스api - 터미널 오퍼레이터(.toList())로 감싸줘서 메모리 낭비를 줄여주자
    val filteredList = upperList
        .asSequence()
        .filter { it == "A" || it == "C" }
        .filter { it == "C" }
        .filter { it == "A" || it == "C" }
        .filter { it == "A" || it == "C" }
        .toList()

    println(filteredList)


}