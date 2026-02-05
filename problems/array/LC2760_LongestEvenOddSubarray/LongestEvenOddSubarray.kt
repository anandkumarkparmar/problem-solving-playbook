class Solution {
    // Time: O(n)
    // Space: O(1)
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        val size = nums.size
        var l = 0
        var r = 0
        var subArraySize = 0

        while (l < size && r < size) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                r += 1
                while (r < size && nums[r] <= threshold && nums[r] % 2 != nums[r-1] % 2) {
                    r += 1
                }

                subArraySize = Math.max(subArraySize, r - l)
                l = r
            } else {
                l += 1
                r += 1
            }
        }

        return subArraySize
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(3, 2, 5, 4), 5),
        Pair(intArrayOf(1, 2), 2),
        Pair(intArrayOf(2, 3, 4, 5), 4)
    )

    for ((nums, thresold) in testCases) {
        println("Input: \nnums:${nums.joinToString()}, thresold: $thresold")
        println("-------------")
        val result = solution.longestAlternatingSubarray(nums, thresold)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
