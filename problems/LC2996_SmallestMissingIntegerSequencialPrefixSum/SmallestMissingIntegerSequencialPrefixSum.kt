class Solution {
    // Time: O(n)
    // Space: O(n)
    fun missingInteger(nums: IntArray): Int {
        val set = HashSet<Int>()
        val size = nums.size
        var sum = nums[0]

        if (size == 1) {
            return sum + 1
        }

        set.add(nums[0])
        var isPrefixSumEnabled = true

        for (i in 1 until size) {
            if (isPrefixSumEnabled && nums[i] == nums[i-1] + 1) {
                sum += nums[i]
            } else {
                isPrefixSumEnabled = false
            }
            set.add(nums[i])
        }

        var ans = sum

        while (true) {
            if (set.contains(ans)) {
                ans += 1
            } else {
                break
            }
        }

        return ans
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1, 2, 3, 2, 5),
        intArrayOf(3, 4, 5, 1, 12, 14, 13)
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.missingInteger(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
