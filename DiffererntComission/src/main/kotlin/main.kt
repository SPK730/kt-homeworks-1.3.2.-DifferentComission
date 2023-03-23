public fun main() {


    var comission = comissionAmount("Visa")//Введите тип карты
    println("Сумма комиссии за перевод: " + (comission) + " руб.")
}

fun comissionAmount(cardType: String): Double {
    return when {
        (cardType == "MasterCard" || cardType == "Maestro") -> MasterCardMaestro(35_000, 10_000)
        (cardType == "Visa" || cardType == "Мир") -> VisaMir(700, 18_000)
        (cardType == "VKpay") -> VKpay(5_000, 120_000)
        else -> 0.0
    }
}

fun MasterCardMaestro(transferAmount: Int, previousMonthTransferAmount: Int): Double {
    return when {
        (transferAmount + previousMonthTransferAmount > 75000) || (transferAmount < 150000) -> (transferAmount / 100 * 0.6) + 20//до 75000 в мес комиссия 0, если больше 0,6% +20 руб)
        else -> 0.0
    }
}

fun VisaMir(transferAmount: Int, previousMonthTransferAmount: Int): Double {
    return when {
        (transferAmount / 100 * 0.75) > 35.0 -> transferAmount / 100 * 0.75
        (transferAmount + previousMonthTransferAmount > 600_000) || (transferAmount < 150000) -> (transferAmount / 100 * 0.75)//0.75 % мин 35 руб
        else -> 35.0
    }
}

fun VKpay(transferAmount: Int, previousMonthTransferAmount: Int): Double {
    return when {
        (transferAmount + previousMonthTransferAmount > 600_000) || (transferAmount < 150000) -> 0.0
        else -> 0.0
    }
}