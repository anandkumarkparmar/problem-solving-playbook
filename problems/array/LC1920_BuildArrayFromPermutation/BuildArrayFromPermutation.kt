class Solution {

    // Time: O(n)
    // Space: O(n)
    fun buildArray1(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        for (i in nums.indices) {
            result[i] = nums[nums[i]]
        }

        return result
    }

    // Time: O(n)
    // Space: O(1)
    fun buildArray2(nums: IntArray): IntArray {
        for (i in nums.indices) {
            val finalValue = nums[nums[i]]
            val currentValue = nums[i]

            if (finalValue < 999) {
                nums[i] = finalValue * 1000 + currentValue
            } else {
                nums[i] = (finalValue % 1000) * 1000 + currentValue
            }
        }

        for (i in nums.indices) {
            nums[i] = nums[i] / 1000
        }

        return nums
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(0,2,1,5,3,4),
        intArrayOf(5,0,1,2,3,4)
    )

    for (testCase in testCases) {
        println("Input: [${testCase.joinToString()}]")
        println("-------------")
        val result = solution.buildArray2(testCase)
        println("Output: [${result.joinToString()}]")
        println("----------------------------------")
        println("----------------------------------")
    }
}