class UpperSection(private val dice: List<Int>) {

    private fun nullIfZero(score: Int) =
        if (score != 0)
            score
        else
            null

    private val ones = nullIfZero(dice.filter { it == 1 }.size * 1)
    private val twos = nullIfZero(dice.filter { it == 2 }.size * 2)
    private val threes = nullIfZero(dice.filter { it == 3}.size * 3)
    private val fours = nullIfZero(dice.filter { it == 4 }.size * 4)
    private val fives = nullIfZero(dice.filter { it == 5 }.size * 5)
    private val sixes = nullIfZero(dice.filter { it == 6 }.size * 6)

    val fields =
        hashMapOf(
            Pair("Ones", ones),
            Pair("Twos", twos),
            Pair("Threes", threes),
            Pair("Fours", fours),
            Pair("Fives", fives),
            Pair("Sixes", sixes)
        )

}
