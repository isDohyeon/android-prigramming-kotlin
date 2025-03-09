package week01

val ticketPriceMap = linkedMapOf(
    5 to 15,
    60 to 30,
    100 to 20
)

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    println("$child 살 가격: \$${ticketPrice(child)}")
    println("$adult 살 가격: \$${ticketPrice(adult)}")
    println("$adult 살 월요일 할인 가격: \$${ticketPrice(adult, true)}")
    println("$senior 살 가격: \$${ticketPrice(senior)}")
    println("1000 살 가격: \$${ticketPrice(1000)}")
}

fun ticketPrice(customerAge: Int, isMonday: Boolean = false): Int {
    if (customerAge < 0 || customerAge > 100) {
        return -1
    }

    var customerPrice = 0
    for ((ageCutLine, ticketPrice) in ticketPriceMap) {
        if (customerAge <= ageCutLine) {
            customerPrice = ticketPrice
            break
        }
    }

    return if (customerPrice == 30 && isMonday) customerPrice - 5 else customerPrice
}
