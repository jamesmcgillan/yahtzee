class LowerSection(private val dice: List<Int>) {

    private val sumOfAllDice = Sum.calculate(dice)

    private val counts =
        setOf(1, 2, 3, 4, 5, 6)
            .map { number ->

                dice.filter { it == number }.size

            }

    private val threeOfAKind =
        if (counts.contains(3))
            sumOfAllDice
        else
            null

    private val fourOfAKind =
        if (counts.contains(4))
            sumOfAllDice
        else
            null

    private val fullHouse =
        if (counts.contains(3) && counts.contains(2))
            25
        else
            null

    private val smallStraight =
        if (
        dice.containsAll(setOf(1, 2, 3, 4)) ||
            dice.containsAll(setOf(2, 3, 4, 5)) ||
            dice.containsAll(setOf(3, 4, 5, 6))
        )
            30
        else
            null

    private val largeStraight =
        if (
        dice.containsAll(setOf(1, 2, 3, 4, 5)) ||
            dice.containsAll(setOf(2, 3, 4, 5, 6))
        )
            40
        else
            null

    private val chance = sumOfAllDice

    private val yahtzee =
        if (dice.distinct().size == 1)
            50
        else
            null

    val fields =
        hashMapOf(
            Pair("Three of a kind", threeOfAKind),
            Pair("Four of a kind", fourOfAKind),
            Pair("Full House", fullHouse),
            Pair("Small straight", smallStraight),
            Pair("Large straight", largeStraight),
            Pair("Chance", chance),
            Pair("Yahtzee", yahtzee)
        )

}