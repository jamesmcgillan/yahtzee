object AvailabeScores {

    fun get(scoreSheet: ScoreSheet,
            upperSection: UpperSection,
            lowerSection: LowerSection): Map<String, Int> {

        val freeFields =
            scoreSheet.fields
                .filter { field -> field.value == null }

        val fromUpperSection =
            upperSection.fields
                .filter { field -> field.value != null }
                .filter { field -> freeFields.containsKey(field.key) }
                .mapValues { field -> field.value!! }
                .toList()

        val fromLowerSection =
            lowerSection.fields
                .filter { field -> field.value != null }
                .filter { field -> freeFields.containsKey(field.key) }
                .mapValues { field -> field.value!! }
                .toList()

        val arrayList = arrayListOf<Pair<String, Int>>()

        arrayList.addAll(fromUpperSection)
        arrayList.addAll(fromLowerSection)

        return arrayList.toMap()

    }

}
