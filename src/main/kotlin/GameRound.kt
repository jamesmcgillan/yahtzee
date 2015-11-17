object GameRound {

    fun apply(scoreSheet: ScoreSheet,
              user: Boolean): ScoreSheet {

        println("Score sheet:")

        scoreSheet.fields.forEach { name, score ->

            val displayedScore = score ?: "--"

            println("$name:\t$displayedScore")

        }

        val diceSelection =
            if (user)
                { dice: List<Int> -> UserDiceSelection.apply(dice) }
            else
                { dice: List<Int> -> AIDiceSelection.apply(dice) }

        val scoreSelection =
            if (user)
                { availableScores: Map<String, Int> -> UserScoreSelection.apply(availableScores) }
            else
                { availableScores: Map<String, Int> -> AIScoreSelection.apply(availableScores) }

        val diceThrow = DiceThrow(diceSelection)

        var dice = listOf<Int>()

        for (i in 1..3) {

            val result = diceThrow.apply(dice)

            dice = result.first

            if (result.second) {

                break

            }

        }

        val upperSection = UpperSection(dice)
        val lowerSection = LowerSection(dice)

        val availabeScores = AvailabeScores.get(scoreSheet, upperSection, lowerSection)

        val selectedScore = scoreSelection(availabeScores)

        scoreSheet.fields.put(selectedScore.first, selectedScore.second)

        val upperSectionValues =
            upperSection.fields.values
                .filter { it != null }
                .map { it!! }

        val upperSectionSum = Sum.calculate(upperSectionValues)

        val bonus =
            if (upperSectionSum < 63)
                35
            else
                0

        scoreSheet.fields.put("Sum", upperSectionSum)
        scoreSheet.fields.put("Bonus", bonus)

        val lowerSectionValues =
            lowerSection.fields.values
                .filter { it != null }
                .map { it!! }

        val lowerSectionSum = Sum.calculate(lowerSectionValues)

        val total = upperSectionSum + bonus + lowerSectionSum

        scoreSheet.fields.put("Total", total)

        return scoreSheet

    }

}