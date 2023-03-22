fun main() {
    var amount = 50
    var comissionAmount = amount * 0.075

    println("Сумма перевода: " + (amount) + " рублей")
    println("Сумма комиссии за перевод: " + (minimumComissionCheck(comissionAmount)) + " рублей")

}

fun minimumComissionCheck(comissionAmount: Double): Double {
    return if (comissionAmount >= 35.0) comissionAmount else 35.0

}