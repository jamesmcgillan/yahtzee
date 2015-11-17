import java.util.*

data class ScoreSheet(

    val fields: HashMap<String, Int?> =

        hashMapOf(
            Pair("Ones", null),
            Pair("Twos", null),
            Pair("Threes", null),
            Pair("Fours", null),
            Pair("Fives", null),
            Pair("Sixes", null),
            Pair("Sum", 0),
            Pair("Bonus", 0),
            Pair("Three of a kind", null),
            Pair("Four of a kind", null),
            Pair("Full House", null),
            Pair("Small straight", null),
            Pair("Large straight", null),
            Pair("Chance", null),
            Pair("Yahtzee", null),
            Pair("Total", 0)
    )

)
