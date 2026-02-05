class Solution {
    // Time: O(n)
    // Space: O(1)
    fun canBeIncreasing(nums: IntArray): Boolean {
        val size = nums.size

        if (size <= 2) {
            return true
        }

        var leftSortedIndex = 0
        for (index in 0..(size - 2)) {
            if (nums[index] < nums[index + 1]) {
                leftSortedIndex = index + 1
            } else {
                break
            }
        }

        if (leftSortedIndex == size - 1 || leftSortedIndex == size - 2) {
            return true
        }

        var rightSortedIndex = size - 1
        for (index in (size - 1) downTo 1) {
            if (nums[index - 1] < nums[index]) {
                rightSortedIndex = index - 1
            } else {
                break
            }
        }

        if (rightSortedIndex == 0 || rightSortedIndex == 1) {
            return true
        }

        if (
            leftSortedIndex == rightSortedIndex - 1 &&
            (nums[leftSortedIndex - 1] < nums[rightSortedIndex] || nums[leftSortedIndex] < nums[rightSortedIndex + 1])
        ) {
            return true
        } else {
            return false
        }
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1, 2, 1, 5, 7), // true
        intArrayOf(1, 2, 2, 5, 7), // true
        intArrayOf(1, 2, 4, 5, 7), // true
        intArrayOf(1, 2, 10, 5, 7), // true
        intArrayOf(1, 2, 10, 5, 12), // true

        intArrayOf(2, 3, 1, 2), // false
        intArrayOf(2, 3, 1, 3), // false
        intArrayOf(2, 3, 1, 4), // true

        intArrayOf(4, 3, 4, 5), // true
        intArrayOf(2, 3, 4, 3), // true

        intArrayOf(1, 1, 1), // false
        intArrayOf(2, 5, 1, 5, 3, 2, 10, 50, 30) // false
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.canBeIncreasing(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
