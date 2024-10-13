package org.example

class HelloBot {
    // 불변을 유지하면서, 해당 변수를 사용하는 시점에 초기화를 함
    // by lazy를 사용할땐 불변성 유지가 전제조건이다
    val greeting: String by lazy(LazyThreadSafetyMode.NONE) {
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()


    // by lazy 내부 로직은 1번만 수행된다
//    helloBot.sayHello()
//    helloBot.sayHello()
//    helloBot.sayHello()

    println("======================")

    // by lazy 내부 로직은 1번만 수행되므로, 멀티 스레드 사용 시 안전성을 보장한다
    for (i in 1..5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

}