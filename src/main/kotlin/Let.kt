package org.example

fun main() {
    val str: String? = "ss "

    val result = str?.let {
        println(it)

        val abc: String? = "abc"
        abc?.let {
            val def: String? = "def"
            def?.let {
                println("abcdef가 null이 아님")
            }
        }

        //return을 안 써도 마지막줄에 있는 값이 반환됨
        1234
    }
    println(result)

    val hello = "Hello"
    val hi = "Hi"

    hello.let {
        println(it.length)

        hi.let { hi ->
            println(hi.length)
        }
    }
}