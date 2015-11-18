class DiceThrow(
    private val diceSelection: (List<Int>) -> Pair<List<Int>, Boolean>
) {

    fun apply(dice: List<Int>): Pair<List<Int>, Boolean> {

        val selection =

            if (dice.isEmpty()) {

                Pair(listOf(), false)

            }
            else {

                diceSelection(dice)

            }

        val keptDice = selection.first
        val keptAll = selection.second

        if (keptAll) {

            return Pair(dice, true)

        }

        val numDiceToRoll = 5 - keptDice.size

        val diceRoll = RollDice.apply(numDiceToRoll)

        val newDice = arrayListOf<Int>()

        newDice.addAll(keptDice)
        newDice.addAll(diceRoll)

        newDice.forEach {

            print("$it ")

        }

        return Pair(newDice, false)

    }

}