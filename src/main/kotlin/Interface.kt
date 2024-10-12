package org.example

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart : Wheel {
    override fun roll() {
        println("카트가 굴러갑니다")
    }

    val coin: Int

    val weight: String
        get() {
            // 인터페이스 내에서는 feild 사용 불가
            return "20kg"
        }

    fun add(product: Product)

    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    fun printId() = println("5678")
}

// 이름이 같은 함수는 인터페이스에서 정의를 해 놓더라도, 실제 구현체에서 다시 오버라이드 받아야 함(1개만 받으면 됨)
class MyCart(override val coin: Int) : Cart, Order {
    // 카트 인터페이스의 add 사용하기
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가되었습니다")

        // 주문 인터페이스의 add 사용하기
        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product("장난감", 1000))
    cart.printId()
}