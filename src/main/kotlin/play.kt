fun main(args: Array<String>) {

    val userScoreSheet = ScoreSheet()
    val aiScoreSheet = ScoreSheet()

    while (userScoreSheet.fields.values.contains(null) || aiScoreSheet.fields.values.contains(null)) {

        if (userScoreSheet.fields.values.contains(null)) {

            GameRound.apply(userScoreSheet, true)

        }

        if (aiScoreSheet.fields.values.contains(null)) {

            GameRound.apply(aiScoreSheet, false)

        }

    }

    if (userScoreSheet.fields.get("Total")!! > aiScoreSheet.fields.get("Total")!!) {

        println("You win! :)")

    }
    else {

        println("Oh noez you lost. :(")

    }

}
