package org.example

import org.intellij.lang.annotations.Language

// 코틀린의 클래스는 기본적으로 모두 final 상태
open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

// Dog 클래스를 상속받음
open class Bulldog(override var age : Int = 0) : Dog() {

    // 오버라이드 받은 인자나 함수들은 자동으로 open 상태가 됨 (open 안붙여줘도 됨)
    // 이때 자동으로 open 상태가 되는 걸 막고 싶다면, final 붙여주면 됨
    final override fun bark() {
        // 하위 클래스에서, 상위 클래스의 인자나 함수를 그대로 재사용하고 싶을 때가 있음
        // 그럴 때는 super로 가져오면 됨
        super.bark()
    }
}

//class ChildBulldog() : Bulldog() {
//    override var age: Int = 0
//    override fun bark() {
//        super.bark()
//    }
//}

// 추상 클래스
abstract class Developer {
    abstract var age: Int

    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int = 0) : Developer() {
    // 추상 클래스에서 만든 인자나 함수들은, 하위클래스에서 무조건 오버라이드를 해 줘야 한다
    override fun code(language: String) {
        println("I code with ${language}")
    }
}

fun main() {
    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("kotlin")

}