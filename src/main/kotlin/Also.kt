package org.example

class User(val name: String, val password: String) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("유효한 유저입니다.")
        } else {
            println("유효하지 않은 유저입니다.")
        }
    }

    fun printName() = println(name)
}

fun main() {
    User("kotlin", "1234").also {
        it.validate()
        it.printName()
    }
}