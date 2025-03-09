package week01.advanced

import java.time.DayOfWeek
import java.time.LocalDate

val today = LocalDate.now().dayOfWeek

val ticketPrices = linkedMapOf(
    5 to 15,
    60 to 30,
    100 to 20
)

fun main() {
    while (true) {
        println("멀티미디어 티켓 판매 프로그램에 오신 것을 환영합니다!")
        print("나이를 입력해주세요 : ")
        val age = readln().toIntOrNull()
        print("구매 갯수를 입력해 주세요 : ")
        val purchaseCount = readln().toIntOrNull()
        printReceipt(age!!, purchaseCount!!)
        println("추가로 구매하시겠습니까? (구매 : y / 종료 : x)")
        if (readln() == "x") break
    }
}

fun ticketPrice(customerAge: Int): Int {
    if (customerAge < 0 || customerAge > 100) {
        return -1
    }

    var customerPrice = 0
    for ((ageLimit, ticketPrice) in ticketPrices) {
        if (customerAge <= ageLimit) {
            customerPrice = ticketPrice
            break
        }
    }

    return customerPrice
}

fun getDiscountAmount(): Int {
    return when (today) {
        DayOfWeek.MONDAY -> -5
        DayOfWeek.TUESDAY -> 0
        DayOfWeek.WEDNESDAY -> 0
        DayOfWeek.THURSDAY -> 0
        DayOfWeek.FRIDAY -> 0
        DayOfWeek.SATURDAY -> 5
        DayOfWeek.SUNDAY -> 5
    }
}

fun printReceipt(age: Int, purchaseCount: Int){
    val price = ticketPrice(age)
    val discount = getDiscountAmount()
    val finalPurchase = (price - discount) * purchaseCount

    println("\n=========== 구매한 티켓 내역 ===========")
    println("$age 세의 기본 티켓 가격 : $price\$, 구매 갯수 : $purchaseCount")
    println("$today 티켓 변동 금액 : $discount\$")
    println("총 구매 가격은 ${(price + discount)}\$ x ${purchaseCount}개 = $finalPurchase\$ 입니다.")
}
