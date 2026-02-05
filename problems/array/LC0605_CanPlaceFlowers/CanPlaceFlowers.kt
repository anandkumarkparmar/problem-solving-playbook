class Solution {
    // Time: O(n)
    // Space: O(1)
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var possiblePlaces = 0
        val flowerbedSize = flowerbed.size

        for (index in flowerbed.indices) {
            if (flowerbed[index] == 0) {
                val leftPlaceEmpty = index == 0 || flowerbed[index - 1] == 0
                val rightPLaceEmpty = index == flowerbedSize - 1 || flowerbed[index + 1] == 0

                if (leftPlaceEmpty && rightPLaceEmpty) {
                    possiblePlaces += 1
                    flowerbed[index] = 1
                }
            }
        }

        return possiblePlaces >= n
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(0), 0),
        Pair(intArrayOf(0), 1),
        Pair(intArrayOf(0), 2),
        Pair(intArrayOf(1), 0),
        Pair(intArrayOf(1), 1),
        Pair(intArrayOf(1), 2),

        Pair(intArrayOf(0, 0), 0),
        Pair(intArrayOf(0, 0), 1),
        Pair(intArrayOf(0, 0), 2),
        Pair(intArrayOf(1, 0), 0),
        Pair(intArrayOf(1, 0), 1),
        Pair(intArrayOf(1, 0), 2),
        Pair(intArrayOf(0, 1), 0),
        Pair(intArrayOf(0, 1), 1),
        Pair(intArrayOf(0, 1), 2),

        Pair(intArrayOf(0, 1, 0), 1),

        Pair(intArrayOf(1, 0, 0, 0, 1), 1),
        Pair(intArrayOf(1, 0, 0, 0, 1), 2)
    )

    for ((flowerbed, n) in testCases) {
        println("Input:\nflowerbed: [${flowerbed.joinToString()}]\nn: $n")
        println("-------------")
        val result = solution.canPlaceFlowers(flowerbed, n)
        println("Output: ${result}")
        println("----------------------------------")
        println("----------------------------------")
    }
}

