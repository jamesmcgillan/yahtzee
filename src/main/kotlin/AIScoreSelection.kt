object AIScoreSelection {

    // First pass :)

    fun apply(availableScores: Map<String, Int>) =

        availableScores
            .toList()
            .reduce { field1, field2 -> if (field1.second > field2.second) field1 else field2 }

}
