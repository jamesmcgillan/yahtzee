object UserScoreSelection {

    // Temporary solution until we do a GUI.
    // Can we do it with Lanterna? :)

    fun apply(availableScores: Map<String, Int>): Pair<String, Int> {

        val availableScoreList = availableScores.toList()

        println("Select your score:")

        availableScoreList.forEachIndexed { index, pair ->

            println("$index\t${pair.first}\t${pair.second}")

        }

        var userInput = -1

        while (!availableScoreList.indices.containsRaw(userInput)) {

            userInput = readLine()!!.toInt()

            println("$userInput is not on the list. Try again.")

        }

        return availableScoreList[userInput]

    }

}