package org.example

enum class PaymentStatus(val value: String): Payable {
    // 뒤에서 함수 쓸거면 맨 마지막에 세미콜론 붙여줘야 됨
    UNPAID("미지급") {
        override fun isPayalbe(): Boolean {
            return true
        }
    },
    PAID("지급완료") {
        override fun isPayalbe(): Boolean {
            return false
        }
    },
    FAILED("지급실패") {
        override fun isPayalbe(): Boolean {
            return false
        }
    },
    REFUNDED("환불") {
        override fun isPayalbe(): Boolean {
            return false
        }
    };
}

interface Payable {
    fun isPayalbe(): Boolean
}

fun main() {
    println(PaymentStatus.UNPAID.value)

    if (PaymentStatus.UNPAID.isPayalbe()) {
        println("결제 가능")
    }

    // 각각의 상수 이름들을 가지고 enum 클래스를 인스턴스화 하는 방법
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.value)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    for (status in PaymentStatus.values()) {
        println("[${status.name}](${status.value}) : ${status.ordinal}")
    }


}