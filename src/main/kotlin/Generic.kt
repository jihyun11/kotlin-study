package org.example

class MyGenerics<out T> (val t: T) {

}

class Bag<T> {
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공해야함
//    val generics = MyGenerics<String>("테스트")

    val generics = MyGenerics("테스트")
    // 제네릭에서는 상속 관계가 성립하지 않기에 공변성을 허용해 주어야 한다!!!
    val charGenerics: MyGenerics<CharSequence> = generics

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()

    // 타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    // 스타프로젝션
    val list3: List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)

    println("=======================")

    // 변성
    // PECS(Producer-Extends, Consumer-Super)
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in
    // 코틀린에서 제네릭은 기본적으로 무공변성을 띤다

    // 반공변성 관계가 된다 = 원래는 CharSequence가 String의 상위타입이었는데, 그 반대가 되는 것
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))

}