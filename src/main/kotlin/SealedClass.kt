package org.example

// sealed 클래스는 하위 클래스가 누구누구인지 다 알고 있는 상태이다
sealed class Developer1 {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper1(override val name: String) : Developer1() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다")

    }
}

data class FrontendDeveloper1(override val name: String) : Developer1() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다")
    }
}

object OtherDeveloper1 : Developer1() {
    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

data class AndroidDeveloper1(override val name: String) : Developer1() {
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다")
    }
}

// 싱글톤 객체
object DeveloperPool {
    val pool = mutableMapOf<String, Developer1>()

    fun add(developer1: Developer1) {
        return when (developer1) {
            is BackendDeveloper1 -> pool[developer1.name] = developer1
            is FrontendDeveloper1 -> pool[developer1.name] = developer1
            is OtherDeveloper1 -> println("지원하지 않는 개발자 종류입니다")
            // sealed 클래스로 바꾸면 컴파일러가 하위 클래스가 누구누구인지 판단한다
            // 백엔드, 프론트 타입으로밖에 구현되지 않았기 때문에 따로 else 조건을 명시해주지 않아도 된다
            else -> {
                println("지원하지 않는 개발자입니다")
            }
        }
    }

    fun get(name: String): Developer1? {
        return pool[name]
    }
}

fun main() {
    val backendDeveloper1 = BackendDeveloper1(name = "토니")
    DeveloperPool.add(backendDeveloper1)
    val frontendDeveloper1 = FrontendDeveloper1(name = "카즈야")
    DeveloperPool.add(frontendDeveloper1)
    val androidDeveloper1 = AndroidDeveloper1(name = "안드로")
    DeveloperPool.add(androidDeveloper1)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("안드로"))

}