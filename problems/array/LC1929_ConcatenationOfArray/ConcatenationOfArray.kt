class Solution {

    // Time: O(n)
    // Space: O(n)
    fun getConcatenation1(nums: IntArray): IntArray {
        val size = nums.size
        val result = IntArray(size * 2) { -1 }

        for (i in nums.indices) {
            result[i] = nums[i]
            result[i + size] = nums[i]
        }

        return result
    }

    // Time: O(n)
    // Space: O(n)
    fun getConcatenation2(nums: IntArray): IntArray {
        return nums + nums
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1, 2, 1),
        intArrayOf(1, 3, 2, 1)
    )

    for (testCase in testCases) {
        val result = solution.getConcatenation2(testCase)
        println("Input: [${testCase.joinToString()}]")
        println("-------------")
        println("Output: [${result.joinToString()}]")
        println("----------------------------------")
        println("----------------------------------")
    }
}