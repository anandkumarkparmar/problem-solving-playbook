class Solution {

    // Time: O(n)
    // Space: O(1)
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var result = 0

        for (operation in operations) {
            if (operation.contains("+")) {
                result += 1
            } else {
                result -= 1
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        arrayOf("--X", "X++", "X++"),
        arrayOf("++X", "++X", "X++"),
        arrayOf("X++", "++X", "--X", "X--")
    )

    for (testCase in testCases) {
        val result = solution.finalValueAfterOperations(testCase)
        println("Input: [${testCase.joinToString()}]")
        println("-------------")
        println("Output: ${result}")
        println("----------------------------------")
        println("----------------------------------")
    }
}