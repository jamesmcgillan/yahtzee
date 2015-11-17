object RollDice {

    fun apply(numDice: Int): List<Int> {

        val dice = IntArray(numDice)

        return dice.map {

            val rand = Math.random()
            assign(rand)

        }

    }

    private fun assign(rand: Double): Int {

        if (rand < 1.0 / 6.0)
            return 1

        if (rand < 2.0 / 6.0)
            return 2

        if (rand < 3.0 / 6.0)
            return 3

        if (rand < 4.0 / 6.0)
            return 4

        if (rand < 5.0 / 6.0)
            return 5

        return 6

    }



}
