package org.example

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {

//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "기본 값"
//    }

//    val result = runCatching { getNumber() }
//        .getOrElse {
//            println(it.message)
//            "기본값"
//        }

//    val result = runCatching { getNumber() }
//        .getOrNull()

//    val result = runCatching { getStr() }
//        .exceptionOrNull()
//
//    result?.let {
//        println(it.message)
//        throw it
//    }

//    val result = runCatching { getStr() }
//        .getOrDefault("기본 값")

//    val result = runCatching { getStr() }
//        .getOrElse {
//            println(it.message)
//            "기본 값"
//        }

//    val result = runCatching { "안녕" }
//        .map {
//            "${it}하세요"
//        }.getOrThrow()

//    val result = runCatching { "안녕" }
//        .mapCatching {
//            throw Exception("예외 발생")
//        }.getOrDefault("기본 값")

//    val result = runCatching { "정상" }
//        .recover { "복구" }
//        .getOrNull()

    // ~Chatching 이면 예외가 발생하더라도 그 다음줄인 디폴드 코드가 실행됨
    val result = runCatching { "정상" }
        .recoverCatching {
            throw Exception("예외")
        }
        .getOrDefault("복구")

    println(result)
}
