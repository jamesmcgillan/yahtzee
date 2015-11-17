object UserDiceSelection {

    fun apply(dice: List<Int>): Pair<List<Int>, Boolean> {

        println("Select dice to keep.")

        println("[Space separated list of indices from 1 through 5. Enter NONE to keep all dice.")

        val userInput = readLine()!!

        if (userInput == "NONE") {

            return Pair(listOf(), false)

        }

        val split = userInput.split(" ")

        val indices = split.map { it.toInt() - 1 }

        if (indices == listOf(0,1,2,3,4)) {

            return Pair(dice, true)

        }

        val keptDice =

            dice.filterIndexed { index, die ->

                indices.contains(index)

            }

        return Pair(keptDice, false)

    }

}