package org.example

// equls, hashcode, toString 지원
data class Person(var name: String, val age: Int)

fun main() {
    val person1 = Person("tony", age = 12)
    val person2 = Person("tony", age = 12)

    // data class로 선언된 객체를 비교하게 되면, 객체의 프로퍼티 값이 동일하면 동일한 객체로 본다
    // 그래서 true가 나오는 것
    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person2))

    println(person1.toString())

    println("===================")

    println(set.contains(person1))
    person1.name ="strange"
    // name 프로퍼티가 변경되면서, 객체의 프로퍼티 값이 동일하지 않아짐
    println(set.contains(person1))

    println("===================")

    // copy
    val person3 = person1.copy(name = "stranger")
    println(person3)

    println("===================")

    // componentN
    // 프로퍼티의 개수와 동일하다
    println("이름 = ${person1.component1()}, 나이 = ${person1.component2()}")


    println("===================")

    // 구조분해 문법
    val (name, age) = person1

    println("이름 = ${name}, 나이 = ${age}")

}