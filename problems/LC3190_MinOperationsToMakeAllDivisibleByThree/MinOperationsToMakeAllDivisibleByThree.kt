class Solution {
    // Time: O(n)
    // Space: O(1)
    fun minimumOperations(nums: IntArray): Int {
        var count = 0
        for (num in nums) {
            if (num % 3 != 0) {
                count += 1
            }
        }

        return count
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(3, 6, 9)
    )

    for (testCase in testCases) {
        val result = solution.minimumOperations(testCase)
        println("Input: [${testCase.joinToString()}]")
        println("-------------")
        println("Output: ${result}")
        println("----------------------------------")
        println("----------------------------------")
    }
}

