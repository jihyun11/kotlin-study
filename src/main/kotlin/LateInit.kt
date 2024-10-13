package org.example

class LateInit {
    // lateinit은 var, not null 전제이다
    lateinit var text: String

    fun printText() {
        text = "안녕하세요"

        // isInitialized는 클래스 내부에서만 사용 가능하다
        if(this::text.isInitialized) {
            println("초기화됨")
            println(text)

        } else {
            text = "안녕하세요"
        }
        println(text)
    }

    // 꼭 바깥에서 isInitialized를 쓰고 싶다면 이런 식으로 getter 안에 넣어줘야 됨
    val textInitialized: Boolean
        get() = this::text.isInitialized
}

fun main() {
    val test = LateInit()
    if (!test.textInitialized) {
        test.text = "하이요"
    }
    test.printText()
}