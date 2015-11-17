object Sum {

    fun calculate(nums: List<Int>) =
        if (nums.isEmpty())
            0
        else
            nums.reduce { a, b -> a + b}

}
