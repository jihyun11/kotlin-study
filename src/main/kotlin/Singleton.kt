package org.example

import java.time.LocalDateTime

object Singleton {
    val a = 1234

    fun printA() = println(a)
}

fun main() {
    println(Singleton.a)
    Singleton.printA()

    println("=================")

    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

    println("=================")

    println(MyClass.a)
    println(MyClass.Jihyun.newInstance())

}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "yyyy-MM-dd"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

class MyClass {

    private constructor()

    companion object Jihyun {
        val a = 1234

        fun newInstance() = MyClass()
    }
}