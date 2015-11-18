object AddSelectedScore {

    fun apply(scoreSheet: ScoreSheet, selectedField: Pair<String, Int>): ScoreSheet {

        scoreSheet.fields.put(selectedField.first, selectedField.second)

        return scoreSheet

    }

}
