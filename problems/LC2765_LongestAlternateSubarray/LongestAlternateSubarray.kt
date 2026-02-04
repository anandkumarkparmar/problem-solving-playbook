class Solution {
    // Time: O(n)
    // Space: O(1)
    fun alternatingSubarray(nums: IntArray): Int {
        var size = nums.size

        for (i in 1 until size) {
            nums[i - 1] = nums[i] - nums[i - 1]
        }

        var longestSubArray = -1
        var left = 0
        var right = 0
        size -= 1

        while (left < size && right < size) {
            if (nums[left] == 1) {
                right = left + 1

                var check = -1
                internal@ while (right < size) {
                    if (nums[right] == check) {
                        check *= -1
                        right += 1
                    } else {
                        break@internal
                    }
                }

                longestSubArray = Math.max(longestSubArray, right - left + 1)
                left += 1
            } else {
                left += 1
            }
        }

        return longestSubArray
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(2, 3, 4, 3, 4),
        intArrayOf(4, 5, 6),
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.alternatingSubarray(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
